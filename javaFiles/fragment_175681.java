int[] array = new int[]{1, 0, 0, 0, 1, 0, 1, 1, 1};
ArrayList<Run> runs = new ArrayList<Run>();
for(int i=0; i<array.length-2; i++){
    if(array[i+1]==array[i]){
        int j = i + 1;
        int count = 2;
        while(array[j+1] == array[i] && j<array.length - 1){
            count++;
            j++;
        }
        if(count>2){
            runs.add(new Run(array[i], i, j));
        }
        i = j;
    }
}
for(Run r : runs){
    System.out.println("There is a run of " + r.length() + 
            " " + r.value() + "'s from index " + r.first() + 
            " to " + r.last() + ".");
}