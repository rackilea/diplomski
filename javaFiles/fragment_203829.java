public static void main(String[] args) {
    try { 
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
    } catch(Exception ignored){}

    new YourClass(); //start your application
}