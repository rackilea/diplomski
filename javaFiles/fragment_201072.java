class MyDriver {

    public static void main(String[] argv){
        // definition of HelpStrategy omitted for brevity
        MyObject myObj = new MyObject(new HelpStrategy() {
            @Override
            public void getHelp() {
                System.out.println("Getting help!");
            }
        });
        myObj.getHelp();
    }

}

class MyObject {
    private final HelpStrategy helpStrategy;

    public MyObject(HelpStrategy helpStrategy) {
        this.helpStrategy = helpStrategy;
    }

    public void getHelp(){
        helpStrategy.getHelp();
    }
}