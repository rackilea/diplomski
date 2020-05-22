Pattern p = Pattern.compile("\"link\"r\\s*:\\s*\"([^\"]+)\",");

 while ((inputLine = in.readLine()) != null) {
     Matcher m = p.matcher(inputline);
     if (m.find()) {
         System.out.println(inputLine);
         bw.write(inputLine);
     } else
         bw.newLine();
 }