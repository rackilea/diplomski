// Simple example
 public static void main(String...args) {
    Date d = new Date();    
    Calendar c = Calendar.getInstance();
    c.setTime(d);
    System.out.println(c.getTime());
    c.add(Calendar.MONTH, 1);
    System.out.println(c.getTime());    
 }