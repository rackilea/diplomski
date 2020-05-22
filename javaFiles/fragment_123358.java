public int compareTo (CustomObject o) {  
    int thisWeight = this.weight;  
    int thatWeight = o.weight;  
    if (thisWeight != thatWeight) {  
        return thisWeight - thatWeight;  
    }  
    else {  
        return this.timestamp - o.timestamp;  
    }  
}