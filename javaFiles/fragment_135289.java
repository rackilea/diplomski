public class child extends Parent {
    //**Error:** We can not append throws clause in the method because
    // parent method do not have a throws clause
    @Override
    public int method() {
        try{
            // Problem Statement
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}