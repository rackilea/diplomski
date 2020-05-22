Form<?> form2 = new Form<Void>("form2") {

    @Override
    protected void onSubmit() {
        StartPage.this.replace( load.tick() );
        // or you can use 
        // StartPage.this.addOrReplace( load.tick() ) 
        // instead
    }
};