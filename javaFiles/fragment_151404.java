String filePathString="PATH"+fileName;
    File f = new File(filePathString);      
            ///////////////////////////////////////////
            if(f.exists() && !f.isDirectory()) {                
                scanFile = new Scanner (new File(fileN`enter code here`ame));
                okuyucu = new Scanner (new File(fileName));
            }   

    while(scanFile.hasNextLine()){
                    zz=scanFile.nextLine();
                    if(zz.contains("MAX")){
                        bir=true;
                        holder1[0]=zz;
                    }
                    if(zz.contains("MIN")){
                        iki=true;
                        holder1[1]=zz;
                    }