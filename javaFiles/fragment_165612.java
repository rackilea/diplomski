returnType function(p1, p2, p3){
   Object[] args = {p1, p2, p3};
   if(Collections.frequency(Arrays.asList(args), null) >= 2) {
        return;
   }
}