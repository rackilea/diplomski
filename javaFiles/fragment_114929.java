Socket s = new Socket("10.0.0.1",4444);

InputStreamReader isr = new InputStreamReader(s.getInputStream());

BufferedReader br = new BufferedReader(isr);

String str = new String();

while ((str = br.readLine())!=null){


    System.out.println(str);

 }