int[] data = new int[items.length];

for (int i = 0; i < items.length ; i++){
   try {
       data[i] = Integer.parseInt(items[i]);
   } 
   catch (NumberFormatException nfe) {};
}