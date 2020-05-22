public int countNumThings() {
        int totalThings=0;
        for (Box box: fullBoxes){
                totalThings = totalThings+box.getNumThings();
        }
        return totalThings;
    }