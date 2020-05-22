try {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        System.out.println(UIManager.getColor("TableHeader.background"));
    } catch (Exception ex) {
        // HANDLE EXCEPTION
    }