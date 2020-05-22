public LargeObject get(String s) {  
    synchronized(map) {
        LargeObject ret = map.get(s);
        if (ret == null) 
            map.put(s, ret = new LargeObject(s));
        return ret;
    }
}