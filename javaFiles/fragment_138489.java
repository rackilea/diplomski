public static BubbleSort(Student[] st) {

    Student temp;   //holding variable
    boolean changed = false;
    for (int j = 0; j < st.length - 1; j++) {
        if (st[j] != null) {
            long studentID1 = st[j].getStudentID();
            if (st[j + 1] != null) {
                long studentID2 = st[j + 1].getStudentID();
                if ((st[j] != null) && (st[j + 1] != null)) {
                    if (studentID1 < studentID2) // change to > for ascending sort
                    {
                        temp = st[j];  //swap elements
                        st[j] = st[j + 1];
                        st[j + 1] = temp;  //shows a swap occurred  
                        changed = true; 
                     }                   
                }
            }

        }
    }
    if (changed) {
        BubbleSort(st);
    }
}