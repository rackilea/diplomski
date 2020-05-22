class degrees
    {
    float faren = 0;
    float cel = 0;

    void degrees(float faren)
    {
       this.faren = faren;
       this.cel = (this.faren-32)*5.0f/9.0f;
    }
    void conversion()
    {
        //System.out.println("Fahrenheit is "+(this.faren-32)*0.55f+"Celcius");
        System.out.println("Fahrenheit is "+this.cel+"Celcius");
    }
    }