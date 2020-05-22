Socket soc = new Socket("192.168.9.7",23999);
//create buffered writer
BufferedReader bwin = new BufferedReader(new InputStreamReader(soc.getInputStream()));
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
while (true) {
        String readFir = bwin.readLine();
        if (readFir == nul) break;
        System.out.println(readFir);
        if(readFir.startsWith("Please")){
            System.out.println("Password Entered");
            bw.write("abc123");
            bw.newLine();
            // instead might have to explicitly write "\r\n"
            // depending platform you're connecting from.
            bw.flush();
        }
        else if(readFir.startsWith("Enter")){
            System.out.println("Enter command");
            bw.write("log set-info 1");
            bw.newLine();
            bw.flush();
            bw.close();  //close buffered Writer
            break;
        } else System.out.println("Skip: " + readFir);
  }