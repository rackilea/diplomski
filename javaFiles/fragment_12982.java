public int compareTo(placeDisplay placeDisplay){
        if (places > placeDisplay.places)
            return 1;
        else if (places == placeDisplay.places)
            return 0;
        else 
            return -1;
    }