BufferedReader br = new BufferedReader(new FileReader(new File("filepath")));
    String line = null;
    StringBuilder sb =new StringBuilder();
    while ((line = br.readLine())!=null) 
    {
        if(line.indexOf(uname)!=-1)
        {
            //do your logic here
            sb.append("your logic here"+"\n");
        }else{
            sb.append(line+"\n");
        }
    } 
    br.close();
    BufferedWriter bw = new BufferedWriter(new FileWriter(new File("filepath")));
    PrintWriter out = new PrintWriter(bw);
    out.print(sb.toString());
    out.flush();
    out.close();