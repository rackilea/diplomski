for(int i = 0; i < pets.length; i++) {
        if (pets[i] instanceof Cat) {
            Cat cat = (Cat) pets[i];
            if (!cat.getIndoorStatus()) {
                System.out.println("Outdoor cat: " + cat);
            }
        }                
    }