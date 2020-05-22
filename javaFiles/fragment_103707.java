String txtName = "test";
    String txtNumbered = "test1";
    try
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(txtName+".txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(txtNumbered+".txt")));
        int count = 0;

        String line = br.readLine();
        while(line != null)
        {
            count++;
            bw.write(count+" "+line+"\r\n");
            line = br.readLine();
        }

        br.close();
        bw.close();

    }catch(IOException e)
    {
        System.out.println(e);
    }