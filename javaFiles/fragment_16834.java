Hashtable<Integer, Hashtable<String, Object>> properties = new Hashtable<Integer, Hashtable<String, Object>>(); 

    Enumeration<Integer> nmExt;
    Enumeration<String> nmInt;

    Hashtable<String, Object> innerHash;
    int externalKey;
    String interanlKey;
    Object obj;

    nmExt = properties.keys();

       while (nmExt.hasMoreElements()){
           externalKey = nmExt.nextElement();

           innerHash =  properties.get(externalKey);

           nmInt = innerHash.keys();

           while (nmExt.hasMoreElements()){
               interanlKey = nmInt.nextElement();

               obj = innerHash.get(interanlKey);

               // .....
           }

        }