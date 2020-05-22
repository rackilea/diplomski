System.out.println("Please enter the length of the song");
String length = sc.next("\\d+\\.\\d{2,}");

String[] split = ("" + length).split("\\.");

double minutes = Double.parseDouble(split[0]);
double seconds = (Double.parseDouble(split[1]));

seconds = (Math.floor(seconds / 60)) + ((seconds % 60) / 100);

System.out.println(minutes + seconds);