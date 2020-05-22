public static Employee PromptForInput()
{
    String firstName;
    String lastName;
    String empID;
    double hourlyRate;
    int hoursWorked;
    double withPercent;

    //...
    Employee user = new Employee(empID);

    user.setFirstName(firstName);
    user.setLastName(lastName);

    //...

    Pay payObj = new Pay();

    payObj .setHourlyRate(hourlyRate);
    payObj .setHoursWorked(hoursWorked);
    payObj .setWithPercent(withPercent);

    // Don't forget to give an instance of Pay to the instance
    // of Employee
    user.setPay(payObj);

    return user;
}