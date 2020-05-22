DefaultElementsAdapter adapter = new DefaultElementsAdapter(this, new Function3<Element, Integer, View, Unit>() {
    @Override
    public Unit invoke(Element element, Integer integer, View view) {
        // your code
        return Unit.INSTANCE;
    }
});