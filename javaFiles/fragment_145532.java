cumsum = int[people+1];
minPos = int[boxes];
maxPos = int[boxes];
Arrays.fill(minPos, -1);
Arrays.fill(maxPos, -1);
int residue = 0;
for(int i=0; i<people; i++){
    cumsum[i+1] = cumsum[i] + chocolateArray[i]; // For simplicity the array length is 1 longer
    residue = cumsum[i+1] % boxes;
    if(minPos[residue] == -1) minPos[residue] = i;
    maxPos[residue] = i;
}
int max = 0;
for(int i=0; i<boxes; i++){
    int sum = cumsum[maxPos[i]+1] - cumsum[minPos[i]+1];
    if(sum > max){
        max = sum;
    }
}
System.out.println(max/boxes);