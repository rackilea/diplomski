public int getLargestObjectIndex() {
        int maxIndex = 0;
        for (int = 1; i < list.size(); i++){
            // compare the area of the current index to the max index
            if (list.get(i).getArea() > list.get(maxIndex).getArea()){
                // if this one is bigger, save the location
                maxIndex = i;
            }
        }
        // output the contents of the object
        System.out.println(list.get(maxIndex).toString())
        // return the location
        return maxIndex;
   }