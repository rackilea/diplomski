Suppler<String> supplier = null;
try {
    supplier = giveMeASupplier() // no exception is thrown here.
} catch (Exception ex) {
    ex.printStackTrace();
}
if (supplier != null) {
    System.out.println(supplier.get()); // this might throw an exception! Yet it's not in a try...catch!
}