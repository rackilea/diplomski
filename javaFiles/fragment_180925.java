String firstcsvFile = "flybirdy_blue.co";
String secondcsvFile = "strongwolf_red.po";
String result = firstcsvFile.substring(firstcsvFile.indexOf("_") + 1, firstcsvFile.indexOf("."));
String result2 = secondcsvFile.substring(secondcsvFile.indexOf("_") + 1, secondcsvFile.indexOf("."));
System.out.println(result);
System.out.println(result2);