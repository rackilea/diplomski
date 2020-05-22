import org.eclipse.jface.layout.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import java.util.*;
import java.util.List;


/**
 * @author Sebastian Raubach
 */
public class StackOverflow
{
    public static void main(String[] args)
    {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setText("StackOverflow");
        shell.setLayout(new GridLayout());

        createMasterPart(shell);

        shell.pack();
        shell.setSize(400, 300);
        shell.open();

        shell.layout(true, true);

        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    private static void createMasterPart(Composite parentComposite)
    {
        Composite composite = new Composite(parentComposite, SWT.NONE);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        composite.setLayout(new GridLayout(1, false));

        Composite tableComposite = new Composite(composite, SWT.NONE);
        TableColumnLayout tableColumnLayout = new TableColumnLayout();
        tableComposite.setLayout(tableColumnLayout);
        tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        TableViewer tableViewer = new TableViewer(tableComposite, SWT.BORDER | SWT.FULL_SELECTION);
        tableViewer.setContentProvider(ArrayContentProvider.getInstance());

        Table table = tableViewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn tableColumn = tableViewerColumn.getColumn();
        tableColumn.setText("Sample");
        tableViewerColumn.setLabelProvider(new ColumnLabelProvider()
        {
            @Override
            public String getText(Object element)
            {
                Dummy p = (Dummy) element;
                return p.getValue();
            }
        });

        tableViewer.addSelectionChangedListener(new ISelectionChangedListener()
        {
            @Override
            public void selectionChanged(SelectionChangedEvent selectionChangedEvent)
            {
                StructuredSelection selection = (StructuredSelection) selectionChangedEvent.getSelection();

                System.out.println(((Dummy) selection.getFirstElement()).getValue());
            }
        });

        List<Dummy> elements = new ArrayList<>();

        for (int i = 0; i < 20; i++)
        {
            elements.add(new Dummy("First option"));
        }

        tableViewer.setInput(elements);

        tableColumnLayout.setColumnData(tableColumn, new ColumnWeightData(1, true));

            /* Set the editing support here */
        tableViewerColumn.setEditingSupport(new FirstValueEditingSupport(tableViewer));
    }

    private static class Dummy
    {
        public String value;

        public Dummy(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return value;
        }

        public void setValue(String value)
        {
            this.value = value;
        }
    }

    public static class FirstValueEditingSupport extends EditingSupport
    {

        private final TableViewer viewer;
        private final CellEditor  editor;

        private final String[] possibleValues = {"First option", "Second option"};

        public FirstValueEditingSupport(TableViewer viewer)
        {
            super(viewer);
            this.viewer = viewer;
            this.editor = new ComboBoxCellEditor(viewer.getTable(), possibleValues);
        }

        @Override
        protected CellEditor getCellEditor(Object element)
        {
            return editor;
        }

        @Override
        protected boolean canEdit(Object element)
        {
            return true;
        }

        @Override
        protected Object getValue(Object element)
        {
            Dummy dummy = (Dummy) element;

            int index = 0;

            for (int i = 0; i < possibleValues.length; i++)
            {
                if (Objects.equals(possibleValues[i], dummy.getValue()))
                {
                    index = i;
                    break;
                }
            }

            return index;
        }

        @Override
        protected void setValue(Object element, Object value)
        {
            Dummy dummy = (Dummy) element;

            int index = (Integer) value;

            dummy.setValue(possibleValues[index]);

            viewer.update(element, null);
        }
    }
}