public void connectToNetworkLocation(){
       try{
        Process p = Runtime.getRuntime().exec("net use \\\\0.0.0.0\\c$ pword /USER:usr");
        p.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }

    }catch(Exception e ){
        e.printStackTrace();
    }
}`