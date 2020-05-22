try {
     Process p = Runtime.getRuntime().exec("ls -l");
     BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
     String str = br.readLine();
     while(str!=null) {
         System.out.println(str);
         str=br.readLine();
     }
}