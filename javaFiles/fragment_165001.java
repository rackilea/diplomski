public static int getShort(int num, int which) {
    if(which == 1){
        return num >>> 16; // Use >>> to avoid sign-extending the result
    } else{
        return num & 0xFFFF;
    }
}