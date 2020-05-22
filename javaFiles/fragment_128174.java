public void clearSubjects()
{
    this.subjects.clear();
}

public void addSubjects(Subject[] subjects)
{
    this.appendSubjects( subjects );
}

private void appendSubjects(Subject[] subjects)
{
    this.subjects.addAll( subjects );
}

public Subject[] getSubjects()
{
    return this.subjects.toArray( new Subject[ 0 ] );
}

public StudentSubJGrade(String name, Subject[] subjects)
{
    this.name = name;
    this.appendSubjects( subjects );
}

private ArrayList<Subject> subjects;