try {
        // Set System L&F
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    // or UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    // or UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel")
} 
catch (Exception e) {
   // handle exception
}