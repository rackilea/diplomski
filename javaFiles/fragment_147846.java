private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    insert.dispatchEvent(new WindowEvent(
        insert, WindowEvent.WINDOW_CLOSING));
}

public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            insert = new Insert();
            insert.setVisible(true);
        }
    });
}

private static Insert insert;
...