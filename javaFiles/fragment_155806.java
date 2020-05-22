public static Stream<Egg> eggs(Hen hen) {
    Iterator<Egg> it = new Iterator<Egg>() {
        @Override
        public boolean hasNext() {
            return hen.hasEgg();
        }

        @Override
        public Egg next() {
            return hen.getEgg();
        }
    };
    return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0), false);
}