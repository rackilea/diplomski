class StringSeperator {

  public static void main(String args[]){
    String urlString = ".........e1.whatsapp.net..............>.ns1.p13.dynect..hostmaster.whatsapp.com.x:a>.......X..:....";
    String array[] = urlString.split("\\.\\.+"); 
    System.out.println(array[1]);
  }
}