try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                .getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                UIManager.put("Menu.foreground", Color.RED);
                UIManager.put("MenuUI", MyMenuUI.class.getName());
                break;
            }
        }
    } catch (Exception ex) {
          ex.printStackStrace();
    }