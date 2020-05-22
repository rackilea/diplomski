public class RegexText {
  static int i=0;
  public static void main(String[] args) {   
      String lines[]={"IBM_%.3r", "ID_%i","%dd/%mm/%yyyy","%dd%mm%yyyy_interface_%i_%i.log","ID_%i"};     
      for(String line: lines){
          System.out.println(randomGenerate(line));
      }
   }

   public static boolean matches(String line, String regex){
       return line.matches(".*"+Pattern.quote(regex)+".*");    
   }
   public static String  randomGenerate(String line){
       Date date=new Date();
       int day=date.getDate();
       int month=date.getMonth()+1;
       int year=date.getYear()+1900;   
       while(matches(line, "%i"))
           line=line.replaceFirst("%i",""+(i++));
       while(matches(line, "%.3r"))
           line=line.replaceFirst("%.3r",""+gen3DigitRand());     
       line=line.replaceAll("%dd",""+to2Digit(day));
       line=line.replaceAll("%mm",""+to2Digit(month));
       line=line.replaceAll("%yyyy",""+year);      
       return line;

   }

   public static int gen3DigitRand(){
       int num=0;
       while(String.valueOf(num).length()!=3)          
           num=(int) (Math.random()*1000);
       return num;
   }
   public static String to2Digit(int num){
       if(num<10)
           return "0"+num;
       return num+"";

   }
}