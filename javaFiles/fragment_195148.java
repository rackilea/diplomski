if(serviceTerms.isSelected() == false) {
    JOptionPane.showMessageDialog(null,"Please accept the terms of service.", "Terms of Service", JOptionPane.ERROR_MESSAGE);
} else {
    this.dispose();
    JOptionPane.showMessageDialog(null,"Thank you. We will now move on to registering your product.");
}