try{
        System.out.println(sPropriété + " --> " + sValeur);
        props.setProperty(sPropriété, sValeur);
        FileOutputStream fos = new FileOutputStream(strFilePath);
        props.store(fos, null);
        fos.close();
    }catch(Exception e){
        System.out.println(e);
    }