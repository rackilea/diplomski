class B extends A {

    @Override
    protected void foo() {
        super.foo();

        //some NEW code
        .......

        //adding click listener to instance of MyButton
        myButton.show(new A.ButtonLogic(){
            @Override
            public void run() {
                super.run();
                .......

                //NEW code
                .......
            }
        });


    }

}