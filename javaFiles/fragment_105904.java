final Load load = new Load();

Form<?> form2 = new Form<Void>("form2") {
    @Override
    protected void onSubmit() {
        StartPage.this.replace( createDataView( load.tick() ) );
    }
};
add(form2);

add( createDataView( new ArrayList() ) );