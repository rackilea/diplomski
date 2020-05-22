public static String[] getLabelData() {
    String[] nameAddressArray = new String[7];
    nameAddressArray[0] = JOptionPane.showInputDialog("Enter title (Mr., Ms., Dr., "
            + "etc.): ");
    nameAddressArray[1] = JOptionPane.showInputDialog("Enter first name: ");
    nameAddressArray[2] = JOptionPane.showInputDialog("Enter lastname: ");
    nameAddressArray[3] = JOptionPane.showInputDialog("Enter street address: ");
    nameAddressArray[4] = JOptionPane.showInputDialog("Enter city: ");
    nameAddressArray[5] = JOptionPane.showInputDialog("Enter state (IL, MO, etc.): ");
    nameAddressArray[6] = JOptionPane.showInputDialog("Enter zip (e.g., 62025): ");
    return nameAddressArray;
}