Student student = dataStorage.getStudent(tempUser);
if (student != null && student.getPass().equals(tempPass))
{
    // login successful
    ...
} else {
    // Login failed - display error message
}