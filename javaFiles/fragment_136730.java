Scanner scan=new Scanner(readFile); // this text file is probably empty
while(scan.hasNext()){              // which makes this condition always false so loop is never executed
    CSDept student=new CSDept();
    student.setStudentName(scan.next());
    student.setJava(scan.nextDouble());
    student.setDataStructure(scan.nextDouble());
    student.setAlgorithms(scan.nextDouble());
    cS.add(student);
}