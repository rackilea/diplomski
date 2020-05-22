while(current1 != null ){
        current2 = front;
        while(current2 != null){
            if( !current1.getItem().equals(current2.getItem())){ //Here 
                aSet.add(current1.getItem());
            }
            current2 = current2.getNext();
        }

        current1 = current1.getNext();
    }