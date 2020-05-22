public static void setGlobalFont( Font font ) {  
        Enumeration keys = UIManager.getDefaults().keys();  
        while (keys.hasMoreElements() ) {  
            Object key = keys.nextElement();  
            Object value = UIManager.get( key );  
            if ( value instanceof Font ) {  
                UIManager.put( key, font );  
            }  
        }  
    }