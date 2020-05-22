while(i < 15) {
    W = 0.6215 * T - 35.75 * Math.pow(V, 0.16) + 0.4275 * T * Math.pow(V, 
        0.16) + 35.74;

    System.out.println("The > Temperature is : " + T + " | The windspeed is: 
    " + V + " | The windchill is: " + W);
    v++;
    i++;
}