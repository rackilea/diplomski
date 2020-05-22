String strAnswer = rs.getString("answer");
if (strAnswer.equals("0")) {
   System.out.println ("Answer Call!");
}
else {
   System.out.println("Do Not Answer!");
}