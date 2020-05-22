public static void main(String[] args) {
    int[] rani = {0,1,2,3,0,0,1,1,0,0};
    int[] um = {0,0,0,0,0,0,0,0,0,0};

    int i = 0, j = 0, k = 0;
    while (i <rani.length) {
        if (rani[i] != 0) {
            j = i;  
            while (i < rani.length) {
                if (rani[i] == 0) {
                    k=i;
                    break;
                } else {
                    i++;
                } 
            }   
            rangeSetValue(um, j, k);   
        } else {
            i++;
        }  
    } 
    doPrint(um, "This is for Matra Processing "); // print the output here
}