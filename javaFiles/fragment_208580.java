public static int summer(List<Integer> list) {
   //base 1
   if (list.size() == 0) {

   }
   //base 2
   else if (list.size() == 1) {

   }
   else
   {
      //no need for if statements now!
      int left = summer(list.sublist(/* */))
      int right = summer(list.sublist(/* */))
      return left + right;
   }
}