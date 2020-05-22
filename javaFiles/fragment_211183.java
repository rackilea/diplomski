private Integer factorial(int number2) throws InterruptedException  {    
    int result = 1;
    while(number2 != 0){    
        result = number2 * result;
        number2 = number2 - 1;
        Thread.sleep(100);    
    }
    System.out.println("result"+result);
    return result;    
}