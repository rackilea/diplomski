private static String getString(String type) {
    String result = JOptionPane.showInputDialog(null, 
            type, 
            "Certified Mail Receipt", 
            3);
    return result;   
}