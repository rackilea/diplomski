if(raz){ 
   out.print(Serwlet.KOD);
   raz = false;
}
String name = request.getParameter("name");   // dostaję nazwisko
String org = ""; //jakas wartosc 
out.write(org != null ?  org : "");
out.flush();