public class TestSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JDialog jDialog = new JDialog();
                    JTable table = new JTable();
                    table.setModel(new DefaultTableModel() {
                        @Override public int getColumnCount() {return 1;}
                        @Override public int getRowCount() {return 1;}
                        @Override
                        public Object getValueAt(int row, int column) {
                            throw new RuntimeException("Hello");
                        }
                    });

                    jDialog.add(table);
                    jDialog.setModal(true);
                    jDialog.pack();
                    Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

                        @Override
                        public void uncaughtException(Thread t, Throwable e) {
                            jDialog.setVisible(false);
                            Thread.setDefaultUncaughtExceptionHandler(null);
                            throw new RuntimeException(e);
                        }
                    });
                    jDialog.setVisible(true);

                    System.out.println("dialog closed");

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("got it");
               }

           }
        });
    }
}