class ManipulationService<T extends Shape & SpecialInterface> {
    public ManipulationService(T myExtendedShape) {
        // method from Shape
        myExtendedShape.onRotate(/* ... */);

        // method from SpecialInterface
        myExtendedShape.getSpecialAttributes();
    }
}