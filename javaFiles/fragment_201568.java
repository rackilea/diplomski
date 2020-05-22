Iterator<Key<Dispensa>> It = dispense.iterator();
    while(It.hasNext()) {
        Key<Dispensa> kk = It.next();
        System.out.println(kk.equals(k));
        if(kk.equals(k)){
            dispense.remove(kk);
            break;
        }
    }