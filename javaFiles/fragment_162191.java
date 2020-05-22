for(int i=0;i<sizebuffer;i++){
    for(int j=0;j<sizeArray;j++){
        farray[j]= some value from other buffer....
    }

    buffer[i]= FloatBuffer.allocate(farray.length);
    buffer[i].put(farray);
}