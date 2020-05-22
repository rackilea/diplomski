int[] textArr = {1, 2, 3, 3, 9};
int[] binaryArr = {4, 5, 6};
int[] mergeArr = new int[textArr.length + binaryArr.length];

int i=0, j=0, k=0;
while(i < textArr.length && j < binaryArr.length) {
    if(textArr[i] < binaryArr[j]) {
        mergeArr[k] = textArr[i];
        i++;
    }
    else {
        mergeArr[k] = binaryArr[j];
        j++;
    }
    k++;
}
// At this point either i == textArr.length or j == binaryArr.length
// so you cannot do textArr[i] < binaryArr[j] without getting
// an ArrayIndexOutOfBoundsException. 
// However the algorithm isn't finished. You still need to transfer
// the remaining numbers from one of the original arrays into the answer.
while(i < textArr.length) {
    mergeArr[k] = textArr[i];
    i++;
    k++;
}
while(j < binaryArr.length) {   // It said i in question. I corrected.
    mergeArr[k] = binaryArr[j];
    k++;
    j++;
}

System.out.println(Arrays.toString(mergeArr));