int[] values = new int[166*376];
for(int i = 0; i<166*125; i++){
    values[i] = 0xff0000; //red
}
for(int i = 166*125; i<166*250; i++){
    values[i] = 0xff00; //green
}
for(int i = 166*250; i<166*376; i++){
    values[i] = 0xff; //blue
}