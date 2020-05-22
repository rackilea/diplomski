Runnable r1 = new Runnable() {
    @Override
    public void run() {
        System.out.println(Test.this); // or Test.this.toString()
    }
};