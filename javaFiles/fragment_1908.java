for(int i=0; i < 100; i++){
        if(i < 3){
            assertNotNull(bto.buildObject());
            System.out.println(bto.count);
        } else {
             assertNull(bto.buildObject());
               System.out.println(bto.count);
        }
    }