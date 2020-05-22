File f = new File(s1);
FileOutputStream fileOut = new FileOutputStream(f);
int myArray [] = new int [20];
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOut));
for (int i = 0 ; i < myArray.length ; i++) {
    myArray [i] = (int) (Math.random () * 8);
}
bw.write(Arrays.toString(myArray));
bw.close();