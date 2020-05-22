public static ArrayList<Frakcijas> ielikt_frakcijas() {
   Frakcijas ier;
   ResultSet zuzis;
   ArrayList<Frakcijas> result = new ArrayList<Frakcijas>();
   zuzis = dbini.db_getallrow("frakcijas");
   try {
       while (zuzis.next()) {
           ier = new Frakcijas();
           ier.frid = zuzis.getInt("frakcijas_id");
           ier.frnos = zuzis.getString("nosaukums");
           result.add(ier);
       }
   } catch (SQLException a) {
       System.out.println(a);
   }
   return result;
}