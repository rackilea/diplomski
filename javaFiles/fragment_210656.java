import java.text.*;
...
SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
sdf.setLenient(false);
try {
       Date dt2 = sdf.parse("20150229105950");
       System.out.println(dt2);
}
catch (Exception exc) {
    System.out.println("NOT VALID");
}