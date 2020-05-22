public void add(T t) {
        if (!(size >= capacity)) { //If there's room...
            if (size == 0) //If the array is empty...
                array[0] = t; //Add to first index
            else
                array[size] = t; //Add to next available index
            size++;
        }
    }

    public void remove(T element) {
        if (size <= 0) //If the array is empty...
            return; //Stop here
        else {
            for (int i = 0; i <= this.size(); i++) { //Linear search front-to-back
                if (array[i].equals(element)) { //Find first match
                    array[i] = null; //Delete it
                    size--;
                    if (i != size) { //If the match was not at the end of the array...
                        for (int j = i; j <= (this.size() - 1); j++) 
                            array[j] = array[j + 1]; //Move everything after the match to the left
                    }
                    return; //Stop here
                }
            }
        }
    }