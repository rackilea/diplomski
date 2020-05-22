public School findSchool(String schoolName)
{
    // Goes through the List of schools.
    for (School i : schools)
    {
        if (i.getName.equals(schoolname))
        {
            return i;   
        }   
    }
}