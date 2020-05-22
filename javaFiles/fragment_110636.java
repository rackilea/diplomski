int[] playerArray = new int[100];
String filename;
for(int i = 0; i<100; i++){
   filename = "player"+String.valueOf(i);
   int rawId = context.getResources().getIdentifier(filename, "raw", context.getPackageName());
   playerArray[i] = rawId;
}