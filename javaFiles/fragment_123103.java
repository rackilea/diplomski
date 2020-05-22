public Student(double avgGPA, int ID, String[] classes, String name){
    super(name);
    setVars(avgGPA, ID, classes);
}

public Student(double avgGPA, int ID, String[] classes, String name, int age){
    super(name, age);
    setVars(avgGPA, ID, classes);
}

public Student(double avgGPA, int ID, String[] classes, String name, int age, String homeTown){
    super(name, age, homeTown);
    setVars(avgGPA, ID, classes);
}

private void setVars(double avgGPA, int ID, String[] classes) {
    this.avgGPA = avgGPA;
    this.ID = ID;
    this.classes = classes;
}