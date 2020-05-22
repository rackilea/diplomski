FileInputStream fis = context.openFileInput("hello.txt", Context.MODE_PRIVATE);
   InputStreamReader isr = new InputStreamReader(fis);
   BufferedReader bufferedReader = new BufferedReader(isr);
   StringBuilder sb = new StringBuilder();
   String line;
   while ((line = bufferedReader.readLine()) != null) {
       sb.append(line);
   }