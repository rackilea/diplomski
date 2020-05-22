public class Student {
// declare variables needed including ID_number, Credit_hours, points and GPA
private float ID_number;
private int Credit_hours;
private int points;
public float GPA;
// methods will go here
//method to return ID number
public float getID_number()
{
    return ID_number;
}
//method to set the ID number
public void setID_number(float ID_number)
{
    this.ID_number = ID_number;
}
//method to return credit hours
public int getCredit_hours()
{
    return Credit_hours;
}
//method to set credit hours
public void setCredit_hours(int Creds)
{
    Credit_hours = Creds;
}
//method to get points
public int getpoints()
{
    return points;
}
//method to set points
public void setpoints(int points)
{
    this.points = points;
}
//method to calculate and return GPA
public float getGPA()
{
    return GPA;

}
//method to print the GPA
public void setGPA(float GPA)
{

    this.GPA = GPA; 

}
}