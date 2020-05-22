boolean loginCorrdect = false;
for (int i = 0; i < thePins.length; i++) {
   if (passEntered.equals(thePins[i]) && pinSize == 4) {
      System.out.println(":)");
      booleanCorrect = true;
      break;
   } else if (!passEntered.equals(thePins[i]) && pinSize == 4) {
      System.out.println(":(");
   }

}
if(!booleanCorrect && pinSize == 4){
   nbTry++;
}