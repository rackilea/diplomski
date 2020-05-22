public static void main (String[] args)
{
    Date kini = new Date();
    java.sql.Date jadwalPengobatan = new java.sql.Date(kini.getTime() + 31l*24l*60l*60l*1000l);
    System.out.println(jadwalPengobatan);
}