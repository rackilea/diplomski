Student[] students;
    System.out.println("Enter number of students :");


    DataInputStream in = new DataInputStream(System.in);
    int n = in.readInt();
    students = new Student[n];
    for(int i=0; i<n ;i++) {
        students[i] = new Student();
        System.out.println("Name:");
        students[i].setName(in.readLine());
        System.out.println("Id:");
        students[i].setNewId(in.readInt());
     }