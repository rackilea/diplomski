new Thread(() -> { 
    Contact[] cnts = Display.getInstance().getAllContacts(true, false, true, false, false, false); 
    for (int i = 0; i < cnts.length; i++) { 
        Contact cnt = cnts[i]; 
        Image pic = cnt.getPhoto(); 
        if(pic != null) { 
           contactsPics.put(cnt.getId(), pic); 
        } 
    } 
}).start();