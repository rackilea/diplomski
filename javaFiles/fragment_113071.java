private final int NO_STUDENTS = 10; 
Students[] s = new Students[NO_STUDENTS];
//populate your array here
//Now run loop
for (int loop = 0; loop < s.length; loop++) {
    System.out.print("Student "+ loop + " >>");
    System.out.println(s[loop].getSubjects());
}