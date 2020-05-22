class A {
    ...
    static class ButtonLogic implements Runnable
    {
        public void run() {...}
    }

    protected void foo() {
        //adding click listener to instance of MyButton
        myButton.show(new A.ButtonLogic());
            .......
    }
}