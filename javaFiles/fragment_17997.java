String input = "Is Mississippi a State where there are many Systems.";
String[] parts = input.split(" ");
String output = "";

 for (int i = 0; i < parts.length; ++i) {
     int smallSIndx = parts[i].indexOf("s");
     int capSIndx = parts[i].indexOf("S");

     if (smallSIndx != -1 && (capSIndx == -1 || smallSIndx < capSIndx))
         output += parts[i].replaceFirst("s", "t") + " ";
     else
         output += parts[i].replaceFirst("S", "T") + " ";
 }

System.out.println(output); //It Mitsissippi a Ttate where there are many Tystems.