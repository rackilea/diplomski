String[] arrayA= {"4444 QH", "5656 JR", "8976 RR"};
String [][] matrix = new String [2][arrayA.length];

String splitted [];
int i=0;

for (String s : arrayA){
    splitted=s.split(" ");
    matrix[0][i]=splitted[0];
    matrix[1][i]=splitted[1];
    i++;
}