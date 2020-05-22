public String readResource(String resource){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream("/resources/"+resource)));
        String line = null;

        String data = "";
        while((line = in.readLine()) != null) {
            if(data!="")data+="\n";
            data+=line;
        }
        return data;
        }catch(IOException e){
            return "";
        }
    }