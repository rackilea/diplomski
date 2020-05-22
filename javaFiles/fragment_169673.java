while(current1 != null){
             boolean found = false;
            current2 = front;
            while(current2 != null && !found){
                if(current1.getItem().equals(current2.getItem())){  
                    found = true;
                } else {
                   current2 = current2.getNext();
               }
            }
            if(!found){
               aSet.add(current1.getItem());
            }
            current1 = current1.getNext();
        }