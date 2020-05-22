String strAnswer = rs.getString("answer");
int intAnswer = Integer.valueOf(strAnswer);
if (intAnswer == 0) {
   System.out.println ("Answer Call!");
}
else {
   System.out.println("Do Not Answer!");
}