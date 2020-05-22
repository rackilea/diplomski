double sum = 0;

String[] arr = str.split(",");
double[] numArr = new int[arr.length];

for(int i=0; i<arr.length; i++){

numArr[i] = Double.parseDouble(arr[i]);

sum+=numArr[i];

}