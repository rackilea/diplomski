public boolean storeMessage(byte[] bt,String hint){
        boolean status=false;

    byte[][] valuePair=null;
    java.util.Set<String> set=null;
    java.util.Iterator<String> itr=null;
    ObjectOutputStream objOut=null;
    try {

        System.out.println("jhkj:"+ht);
        ht=getMessage();//<--Here you are trying to get current hashtable 
        if(ht==null) 
           ht=new Hashtable<String, byte[]>();

        ht.put(hint, bt);

        keyPair=new String[ht.size()];
        valuePair=new byte[keyPair.length][1];

        set=ht.keySet();
        itr=set.iterator();
        int i=0;
        while(itr.hasNext()){
            keyPair[i]=itr.next();
            valuePair[i]=ht.get(keyPair[i]);
            i++;
        }

    if(!new java.io.File("store.db").exists()) 
        new java.io.File(path+ "/store.db").createNewFile();  


    objOut=new ObjectOutputStream(new FileOutputStream(path+ "/store.db",true));
    objOut.writeObject(keyPair);
    objOut.writeObject(valuePair);
    objOut.close();
    status=true;
    } catch (Exception e)
    {
    }
    finally{            
    }
    return status;
}