public String toString(){
    String classString = "";
    for(Student student : roster){
        if (student != null)
          classString += student.toString() + "\n";
    }

    return classString;
}