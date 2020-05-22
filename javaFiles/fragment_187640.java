public static void main(String[] args) {                                        
    double input; //need to implement this                                      
    double v=9999999.99;                                                        

    while(input > v) {                                                          
        System.out.print(v + " ");                                              
        input -= v; //subtract                                                  
    }                                                                           
    System.out.println(input);                                                  
}