public void setUp()
{
    appointment = new Appointment(hour, description);
    this.hour = hour;
    this.description = description;
    hour = 7; //this statement is overriding your this.hour = hour statement. what is the point?
    description = ""; //this statement is overriding your this.description = description statement. what is the point?
    newHour = 1;
    newDescription = "hello";
}