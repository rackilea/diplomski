public static void main(String[] args) {
    //Locale.setDefault(Locale.FRANCE);
    ExceptionGenerator eg = new ExceptionGenerator();

    try {
        eg.generateException();
    } catch (MyLocalizedThrowable e) {
        System.out.println(e.getLocalizedMessage());
    }
}