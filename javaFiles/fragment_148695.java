public static void main (String[] args){
     String s = "cn=harry,cn=group,ou=users,ou=myCompany,ou=customers,dc=this,dc=that";

     String first = s.replaceAll(".*?,ou=(.*?),.*", "$1");
     String middle = s.replaceAll(".*?,ou=.*?,ou=(.*?),.*", "$1");
     String third = s.replaceAll(".*,ou=(.*?),.*", "$1");

     System.out.println(first);
     System.out.println(middle);
     System.out.println(third);
}