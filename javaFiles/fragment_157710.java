if (searchSupplier.getParent() == null) {
    Main.getInstance().getPortada().getDesktop().add(searchSupplier);
}
searchSupplier.setVisible(true);
Main.getInstance().getPortada().getDesktop().moveToFront(searchSupplier);
try {
    searchSupplier.setSelected(true);
} catch (PropertyVetoException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}