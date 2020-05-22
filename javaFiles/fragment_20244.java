synchronized(out){
    for(int i=0; i<in.length(); i++) {
        out.append(in.substring(i,i+1));

        if(in.charAt(i) == '.') {
            pause(30);
        }
        else {
            pause(200);
        }
    }      
}