public boolean isPowerOf2(float number){
    if(number>1){
        //easy to write
    }else if(number==1){
        return true;
    }else if(number>0){
        return isPowerOf2(1.0f/number);
    }else
        return false;
}