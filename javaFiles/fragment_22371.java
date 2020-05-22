String[] stateCapsArray = str_data.split(":");
for(int i=0;i<stateCapsArray.length-1;i++) {
    //Skip each other element as we are collecting 2 elements at a time
    if(i%2 == 0) {
        String state = stateCapsArray[i];
        String capital = stateCapsArray[i+1];
        capitals.put(state, capital);
    }
}