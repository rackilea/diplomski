void add(Student newStudent){
    int i = 0;
    while(i != classSize){    //classSize is the size of the roster array
        if(roster[i] == null {   //roster is an array of Student objects
            roster[i] = newStudent;
        }
        i++;
    }
}