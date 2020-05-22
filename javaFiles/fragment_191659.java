char[][] original = new char[3][3];
char[][] copy = new char[orignal.length][0];

for(int i = 0; i < original.length; i++){
    copy[i] = original[i].clone();
}