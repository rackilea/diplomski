public static void main(String args[]) {
    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {


               if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
               }
            }
    } catch (Exception ex) {
               ex.printStackTrace();
    }

    new PrincipalFrame().setVisible(true); // now you have set nimbus L&f

}