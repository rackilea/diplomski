String aVeryLongString="aaabbbcccdddeeefffggghh";
String aShortString="abc";
String anotherString="helloWorld";

String formattedString=String.format("%5.5s,%5.5s,%5.5s",aVeryLongString,aShortString,anotherString);

System.out.println(formattedString);