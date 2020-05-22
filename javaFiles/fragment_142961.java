interface ConstantSupplier {
    List<Long> get();
}

public MyClass(ConstantSupplier supplier) {
    this.supplier = supplier;
}