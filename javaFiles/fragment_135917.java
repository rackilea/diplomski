String[] cities = new String[3];
String[] zipCodes = new String[3];

for (int i = 0; i < 3; i++) {
    System.out.println ("Please enter your City No." + (i + 1) + ":");
    cities[i] = keyboard.nextLine().toUpperCase();
    System.out.println ("Please enter your Zipcode No." + (i + 1) + ":");
    zipCodes[i] = keyboard.nextLine();
}

System.out.println("------------------------------------------------------");
System.out.println("EVAN'S WEATHER FORECAST FOR: SUNDAY, OCTOBER 07, 2013");
System.out.println("------------------------------------------------------");
System.out.println("City   Zip   Code    Temp   Relative   Humidity");

for (int i = 0; i < 3; i++) {
    System.out.println(cities[i] +" " + zipCodes[i] + 
                    port.getCityWeatherByZIP(zipCodes[i]).getTemperature() + 
                    port.getCityWeatherByZIP(zipCodes[i]).getRelativeHumidity());
}