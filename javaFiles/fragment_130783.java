new BiConsumer<MutableContainer,Long>() {
    @Override
    public void accept(MutableContainer t, Long u) {
         t.reduce(u);
     }
}