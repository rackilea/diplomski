//Change the method for find to return the index, but returns -1
// if the name isn't found which can be used to let a caller of 
// the function know that it does not exist as I will show in the removeStudent()
private int findStd (String stdName)
{
    int indexOfStudent = -1;

    for(int i = 0; i < students.length; i++)
    {
        if(stdName.equalsIgnoreCase(students[i].studentName))
        {
           indexOfStudent = i;
           break;
        }
    }
   //now we will either return a valid index or -1
   return indexOfStudent;
}

private boolean removeStudent()
{
    String name = JOptionPane.showInputDialog("What's the student's name (last, first)?");
    //if the name exists then our findStd() will give us the index
    int indexToRemove = findStd(name);
    if(indexToRemove != -1)
    {
        students[indexToRemove] = null;
        return true;
    }
    return false;
}