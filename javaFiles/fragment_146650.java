try{
    BufferedReader r = new BufferedReader(new InputStreamReader(address.openStream()));
    try{

        String inLine;
        while ((inLine = r.readLine()) != null) {
            System.out.println(inLine);
        }
    }finally{
        r.close();
    }
}catch(IOException e){
    e.printStackTrace();
}