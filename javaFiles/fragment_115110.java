try {
        // Set cross-platform Java L&F (also called "Metal")
    UIManager.setLookAndFeel(
        UIManager.getCrossPlatformLookAndFeelClassName());
} 
catch (UnsupportedLookAndFeelException e) {
   // handle exception
}
catch (ClassNotFoundException e) {
   // handle exception
}
catch (InstantiationException e) {
   // handle exception
}
catch (IllegalAccessException e) {
   // handle exception
}