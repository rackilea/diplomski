class ABC {

    public static Object xxx(int a, int b) throws Exception{
        Object returnValue = null;
        returnValue = a / b;
        return returnValue;
    }

    public static void main(String a[]){
        try {
            xxx(1, 2);
        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }
}