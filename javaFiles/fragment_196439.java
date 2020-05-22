for(int inx=0; inx<pit.size() && h < sampleNum.size(); inx++){
    if(pit.get(inx).equals(sampleNum.get(h))){
       //add the value, of the same index, from pit2 to the mncov arraylist
       mncov.add(pit2.get(inx));
       h++;
    }
}