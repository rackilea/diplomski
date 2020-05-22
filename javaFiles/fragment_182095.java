int max = a[0];
int maxIndex = 0;//take a variable & Initialize to 0th index
for (int i=0; i<a.length;i++) {//normal for loop, not for each
    if (max < a[i]) {
        max = a[i];
        maxIndex = i;//capture the maxIndex
    }
}
System.out.println(": maxIndex :"+maxIndex);//print the maxIndex