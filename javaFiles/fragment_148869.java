public static <T> T wrapperMethod (Supplier<T> supp) {
    boolean flag = true;
    int counter = 1;
    T value = null;

    while (flag) {
       try {
            value = supp.get(); 
            flag = false;
       } catch (Exception e) {
           try {
                if (counter == 5) {
                    System.out.println("Timeout Occured!");
                    flag = false;
                } else {
                    Thread.sleep(1000 * counter);
                    counter++;
                }
            } catch (InterruptedException e1) {
            }
        }
    }
}