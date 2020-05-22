int [] [] marks = {{1,2,3,4,5}, {6,7,8,9}, {10,11,12}};         

int sum = 0;
for(int i = 0; i<marks.length; i++){
    for(int j = 0; j <marks[i].length; j++){
        sum = sum + marks[i][j];
    }
}
System.out.println(sum);