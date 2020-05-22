private Range[] getRanges(int[] toBeProcessed){
    Range[] result = new Range[toBeProcessed.length]; //larger array won't be needed
    int startRange = toBeProcessed[0];  
    int ranges = 0;
    for(int a=0; a<toBeProcessed.length; a++){
        try{
            if(toBeProcessed[a] + 1 != toBeProcessed[a+1]){                 
                result[ranges] = new Range(startRange, toBeProcessed[a]);
                startRange = toBeProcessed[a+1];
                ranges++;
            }                   
        }catch(ArrayIndexOutOfBoundsException e){
            result[ranges] = new Range(startRange, toBeProcessed[toBeProcessed.length-1]);
        }
    }
    return result;      
}