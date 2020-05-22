boolean helpon(String what){
    FileReader fr;
    BufferedReader br;
    int ch;
    String topic, info;

    try{
        fr = new FileReader(helpfile);
        br = new BufferedReader(fr);
        do{
            ch = br.read();
            if(ch=='#'){
                topic = br.readLine();
                if(what.compareTo(topic) == 0){
                    do{
                        info = br.readLine();
                        if(info!=null)
                            System.out.println(info);
                    }while((info!= null) && (info.compareTo("")!= 0));
                    return true;
                }
            }
        }while(ch!=-1);
    } catch(IOException e){
        System.out.println(e);
        return false;
    } catch(FileNotFoundException e){
        System.out.println(e);
        return false;
    } finally {
        try {
            if (br != null) {
                br.close();
            }
        } catch(IOException e){
            System.out.println(e);
            return false;
        }
    }
}