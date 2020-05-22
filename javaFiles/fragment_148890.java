public void StringtoBCD(String StringElement) {
        PrintStream in = System.out;
        if(StringElement.length()%2 == 1) {
            StringElement= "0"+StringElement;
        }
        if (!" ".equals(StringElement)){
            byte[] tempBCD = StringElement.getBytes();
            for (int i=0; i<tempBCD.length; i++){
                tempBCD[i]=(byte)(tempBCD[i]-0x30);
            }
            for(int i = 0; i<tempBCD.length; i=i+2){
                in.write((tempBCD[i]<<4)+tempBCD[i+1]);
            }
        }
        in.flush();
    }