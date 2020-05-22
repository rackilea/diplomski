public void shuffle(int[] t){
   int temp = 0;
   int j = 0;
   for(int i = 0; i < t.length; i++){
        j = (int)(Math.random() * t.length);
        temp = t[j];
        t[j] = t[i];
        t[i] = temp;
   }
}