public void setSubjects(Subject[] subjects)
{
    this.copySubjects( subjects );
}

private void copySubjects(Subject[] subjects)
{
    final int arraySize = subjects.length;

    this.subjects = new Subject[ arraySize ];
    System.arraycopy( subjects, 0, this.subjects, 0, arraySize );
}

public StudentSubJGrade(String name, Subject[] subjects) {
    this.name = name;
    this.copySubjects( subjects );
}