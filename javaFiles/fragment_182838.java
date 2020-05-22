public void readStream(){
        try{
            while(in.read()!=-1){
                char c = (char) in.read();
                msg = msg + c;
            }in.close();
        }catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }