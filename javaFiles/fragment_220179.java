class Teaching {
  private Hash lectRef; // assoc. array 

  public void addTeaching(Lecturer lect, Student stud, Subject subj) {
    if lectRef[lect.hash] == None { lectRef[lect.hash] = []; }  
    // if none, default an empty array here
    // lect.hash is a unique hash code for the Lecturer object

    lectRef[lect.hash].append((stud, subj); 
    // tuple of student/subject referenced

    // if you need other fast results (e.g. subjects per student or the like) you need to hash them here too
  }

  public [(Stud, Subj)] studSubj (Lecturer lect) {
    return lectRef[lect.hash];  
    // returns the array of student/subject tuples
  }

  // add other result operations like subjects per student as needed
}