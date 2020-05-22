public void fileWrite(String fileName,ArrayList<PeopleDetails> person){
        File           f ;
        FileWriter     fw = null;
        BufferedWriter bw = null;
        try {
            f  = new File(fileName);
            fw = new FileWriter(f.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            for(PeopleDetails i:person){
                bw.write(i.name+","+i.number+";");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(bw!=null)
                    bw.close();
                if(fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   
    }