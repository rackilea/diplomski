public static void main(String[] args) {
    myMethod(); /* No catching needed */
    try {
        mySecondMethod();
    } catch(MyException e){
        /* Catching needed */
    }
}