if (sales > 10) {
    if (sales >= 10 || sales <= 19)  
        rate = 0.20;  
    else if (sales >= 20 || sales <=49)  
        rate = 0.30;  
    else if (sales >= 50 || sales <=99)  
        rate = 0.40;  
    else if (sales > 100)  
        rate = 0.50;  
    System.out.println("Your discount is $" + (int)discount + 
                                   ". Your total is: $" + (int)total);
} else {

    System.out.print("No discount. " + 
                                 "Your total is: $" + (int)total);
}