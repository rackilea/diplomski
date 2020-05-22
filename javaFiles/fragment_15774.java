public void calProfitIndex(ArrayList<ArrayList<Package>> elemetList,ArrayList<Integer> capacity){
        Iterator elemetListIterator=elemetList.iterator();
        Iterator capacityIterator=capacity.iterator();
        while(elemetListIterator.hasNext() && capacityIterator.hasNext()) {
            ArrayList<Package> elemet=(ArrayList<Package>) elemetListIterator.next();
            Integer cap=(Integer) capacityIterator.next();
        }
    }