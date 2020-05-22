public class MainClass {
    public void run(String infoOne, String infoTwo, String infoThree,
                    String infoFour, String infoFive, String infoSix) {        
        SomeClass someClass = new SomeClass();
        log(() -> someClass.runSomeMethod());
        log(() -> someClass.runSomeMethodTwo(infoOne));
        log(() -> someClass.runSomeMethodThree(infoThree, infoOne, infoSix));
        log(() -> someClass.runSomeMethodFour(infoTwo, infoFive));
        log(() -> someClass.runSomeMethodFive(infoThree, infoFive, infoOne, infoSix));
    }
    public void log(BooleanSupplier method) {
        try {
            if(method.getAsBoolean()) {
                System.out.println("Success!");
            } else {
                System.out.println("Failed to execute!");
            }
        } catch (Exception e ){
            e.printStackTrace();
        }
    }
}