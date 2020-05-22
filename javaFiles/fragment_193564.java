public static void main(String[] args) {
   List obj = new ArrayList<Integer>();

   //this is allowed (no warning), even though it will fail at runtime
   CharSequence sequence = (CharSequence) obj; 
}