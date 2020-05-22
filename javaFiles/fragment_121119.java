package naveed.workingfiles;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateToString {

public static void main(String[] args) {

String laDate="2013-06-15";
String dateString = laDate.substring(8, 10) + "/"
            + laDate.substring(5, 7) + "/"
            + laDate.substring(0, 4);
Date date= new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
String dateFormat = "dd-MMM-yyyy";
SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, new Locale("en_US"));
String tDate = sdf.format(date);
System.out.println(tDate);//here your String date 

}

}