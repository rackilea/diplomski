public String getTemperatureMessage(double temp){
    String message;
    if(temp < 32)
        message = "Freezing";
    if(temp < 60)
        message = "Brr";
    if(temp < 80)
        message = "Comfortable";
    else 
        message = "Too hot";
    return message;
}