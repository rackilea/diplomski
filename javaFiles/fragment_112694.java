import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.swing.FilePane;
import darrylbu.util.SwingUtils;

@SuppressWarnings("restriction")
public class JFileChooserPersisterFactory {
    private static final String VIEW_TYPE_LIST = "viewTypeList"; //$NON-NLS-1$
    private static final String VIEW_TYPE_DETAILS = "viewTypeDetails"; //$NON-NLS-1$
    private static final String CHOOSER_CLOSING_PROPERTY = "JFileChooserDialogIsClosingProperty"; //$NON-NLS-1$
    private static final String VIEW_TYPE_PROPERTY = "viewType"; //$NON-NLS-1$
    private static final String IS_DETAILS = "isDetails"; //$NON-NLS-1$
    private static final String SORT_ORDER = "sortOrder"; //$NON-NLS-1$

    private JFileChooserPersisterFactory() {
    }

    public static JFileChooserPersister createJFileChooserPersister() {
        JFileChooserPersisterImpl persister = new JFileChooserPersisterImpl();
        persister.init();
        return persister;
    }

    public interface JFileChooserPersister extends AutoCloseable {
        JFileChooser getJFileChooser();

        @Override
        void close();
    }

    private static class JFileChooserPersisterImpl implements JFileChooserPersister {
        private final Logger logger = LoggerFactory.getLogger(getClass());
        private final Preferences persistentPrefs = Preferences.userNodeForPackage(getClass());

        private final JFileChooser chooser;
        private boolean isDetails;
        private OnChooserClosing chooserClosingListener;
        private FilePane filePane;
        private OnViewTypeChanged viewTypeChangedListener;

        public JFileChooserPersisterImpl() {
            chooser = new JFileChooser();
        }

        public void init() {
            restoreSettings();
            registerForViewTypeChangeEvents();
            chooserClosingListener = new OnChooserClosing();
            chooser.addPropertyChangeListener(CHOOSER_CLOSING_PROPERTY, chooserClosingListener);
        }

        @Override
        public JFileChooser getJFileChooser() {
            return chooser;
        }

        private void persistSettings() {
            persistentPrefs.putBoolean(IS_DETAILS, isDetails);
            if (isDetails) persistSortOrder();
        }

        private void persistSortOrder() {
            byte[] serializedSortOrder = serializeSortOrder();
            if (serializedSortOrder != null)
                persistentPrefs.putByteArray(SORT_ORDER, serializedSortOrder);
        }

        private byte[] serializeSortOrder() {
            List<? extends SortKey> keys = getRowSorter().getSortKeys();
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            try (ObjectOutputStream out = new ObjectOutputStream(byteStream)) {
                out.writeObject(new SortOrderInfo(keys));
                return byteStream.toByteArray();
            } catch (IOException e) {
                logger.error("Could not serialize JFileChooser row sort order.", e); //$NON-NLS-1$
            }
            return null;
        }

        private void restoreSettings() {
            isDetails = persistentPrefs.getBoolean(IS_DETAILS, false);
            if (isDetails) {
                setToDetailsView();
                applyInitialSortOrder();
            } else {
                setToListView();
            }
        }

        private void setToDetailsView() {
            Action details = chooser.getActionMap().get(VIEW_TYPE_DETAILS);
            details.actionPerformed(null);
        }

        private void setToListView() {
            Action details = chooser.getActionMap().get(VIEW_TYPE_LIST);
            details.actionPerformed(null);
        }

        private void applyInitialSortOrder() {
            byte[] serializedSortOrder = persistentPrefs.getByteArray(SORT_ORDER, null);
            if (serializedSortOrder == null) return;
            ByteArrayInputStream byteStream = new ByteArrayInputStream(serializedSortOrder);
            try (ObjectInputStream in = new ObjectInputStream(byteStream)) {
                setSortInfo((SortOrderInfo) in.readObject());

            } catch (IOException | ClassNotFoundException e) {
                logger.error("Could not deserialize JFileChooser row sort order.", e); //$NON-NLS-1$
            }
        }

        private void setSortInfo(SortOrderInfo info) {
            info.setSortOrder(getRowSorter());
        }

        private RowSorter<?> getRowSorter() {
            JTable table = SwingUtils.getDescendantsOfType(JTable.class, chooser).get(0);
            RowSorter<?> rowSorter = table.getRowSorter();
            return rowSorter;
        }

        private void registerForViewTypeChangeEvents() {
            filePane = SwingUtils.getDescendantsOfType(FilePane.class, chooser).get(0);
            viewTypeChangedListener = new OnViewTypeChanged();
            filePane.addPropertyChangeListener(VIEW_TYPE_PROPERTY, viewTypeChangedListener);
        }

        private final class OnChooserClosing implements PropertyChangeListener {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                persistSettings();
            }
        }

        private class OnViewTypeChanged implements PropertyChangeListener {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                isDetails = ((int) evt.getNewValue()) == FilePane.VIEWTYPE_DETAILS;
            }
        }

        public static class SortOrderInfo implements Serializable {
            private static final long serialVersionUID = -5393878644049680645L;
            private final List<ColumnSortInfo> keyInfo = new ArrayList<>();

            public SortOrderInfo(List<? extends SortKey> keys) {
                for (SortKey sortKey : keys) {
                    keyInfo.add(new ColumnSortInfo(sortKey));
                }
            }

            public void setSortOrder(RowSorter<?> rowSorter) {
                rowSorter.setSortKeys(makeSortKeys());
            }

            private List<SortKey> makeSortKeys() {
                List<SortKey> keys = new ArrayList<>();
                for (ColumnSortInfo info : keyInfo) {
                    keys.add(info.makeSortKey());
                }
                return keys;
            }

            public static class ColumnSortInfo implements Serializable {
                private static final long serialVersionUID = 5406885180955729893L;
                private final SortOrder sortOrder;
                private final int column;

                public ColumnSortInfo(SortKey sortKey) {
                    column = sortKey.getColumn();
                    sortOrder = sortKey.getSortOrder();
                }

                public SortKey makeSortKey() {
                    return new SortKey(column, sortOrder);
                }
            }
        }

        @Override
        public void close() {
            chooser.removePropertyChangeListener(CHOOSER_CLOSING_PROPERTY, chooserClosingListener);
            filePane.removePropertyChangeListener(VIEW_TYPE_PROPERTY, viewTypeChangedListener);
        }
    }
}