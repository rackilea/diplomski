EditNode mynode;
while (start != null){
    mynode = start.editnext;
    start.editnext = null;
    start = mynode;
}