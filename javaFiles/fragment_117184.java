if(l.size()<100){
        l.add((HashMap<String,Object>)payload);
    }else {

         LOG.info("Just handing off to write :: => Size is "+l.size());
         handoff(l);
         l=new ArrayList<HashMap<String,Object>>();
         l.add((HashMap<String,Object>)payload)
    }