String getMaturityLevel(int age) {
    String maturity = "antique";
    if(age < 2)
        maturity = ("a baby");
    else if(age < 4)
        maturity = ("a toddler");
    else if(age < 13)
        maturity = ("a child");
    else if(age < 20)
        maturity = ("a teenager");
    else if(age < 35)
        maturity = ("a young adult");
    else if(age < 65)
        maturity = ("middle aged");
    else if(age < 100)
        maturity = ("geriatric");

    return maturity; 
}