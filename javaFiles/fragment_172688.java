if( samples.length % 2 == 0){
    temp = new double[samples.length / 2];
}
else { // samples.length % 2 != 0 is implied, since it's else
    temp = new double[samples.length / 2 + 1]; // corrected -1 to +1
}