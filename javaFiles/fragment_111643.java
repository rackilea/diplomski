import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.*;
import javax.swing.event.*;

public class TestListModel {
    public TestListModel() {

        DefaultListModel model = new DefaultListModel();
        model.addElement(new DocumentWrapper("Doc 1", "Doc 1 data"));
        model.addElement(new DocumentWrapper("Doc 2", "Doc 2 data"));
        model.addElement(new DocumentWrapper("Doc 3", "Doc 3 data"));

        final JList list = new JList();

        final JTextArea output = new JTextArea(5, 40);
        list.setModel(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.setCellRenderer(new DocumentWrapperRenderer());

        list.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            DocumentWrapper docWrapper = (DocumentWrapper) list
                                    .getSelectedValue();
                            if (docWrapper != null) {
                                output.setText(docWrapper.getData());
                            } else {
                                output.setText("");
                            }
                        }
                    }
                });

        JFrame frame = new JFrame("Document list");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(list));
        frame.add(output, BorderLayout.SOUTH);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public class DocumentWrapper {
        private String data;
        private String name;

        public DocumentWrapper(String name, String data) {
            this.name = name;
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public String getName() {
            return name;
        }
    }


    public static class DocumentWrapperRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean hasFocus) {
            if (value instanceof DocumentWrapper) {
                return super.getListCellRendererComponent(
                        list, ((DocumentWrapper) value).getName(), index,
                        isSelected, hasFocus);
            }
            return super.getListCellRendererComponent(list, value, index, 
                    isSelected, hasFocus);
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestListModel();
            }
        });
    }
}