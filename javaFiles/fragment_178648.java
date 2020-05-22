long timeInMillis = 3032;
String text = String.format("%d:%02d:%02d.%03d", 
        timeInMillis / 3600000,
        timeInMillis / 60000 % 60,
        timeInMillis / 1000 % 60,
        timeInMillis % 1000);
System.out.println(text);