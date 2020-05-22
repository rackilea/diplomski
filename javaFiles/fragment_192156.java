public class Test {

    public static void main(String[] args) {
        Inst instObj;
        try {
            instObj = Builder.createInst(Inst.class);
            System.out.println(instObj.getVar());
        } catch (InstantiationException | IllegalAccessException e) {
            //e.printStackTrace();
        }
    }

}