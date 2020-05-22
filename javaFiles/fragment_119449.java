BufferedReader br = new BufferedReader(new FileReader(new File("D:/Shashank/random.txt")));
        StringBuffer sb = new StringBuffer("");
        String address =  "line1\nline2\nline3";

        while(br.ready())
        {
            sb.append(br.readLine());
            sb.append("\n");
        }
        if(sb.indexOf(address)>=0)
        {
            System.out.println("Address found");
        }