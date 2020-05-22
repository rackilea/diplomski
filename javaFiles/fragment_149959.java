String firstName = InputHelper.getInput("Enter new first name: ");
    student.setFirstName(firstName);

    String lastName = InputHelper.getInput("Enter new last name: ");
    student.setLastName(lastName);

    Date dob = InputHelper.getDateInput("Enter new date ");
    student.setDateOfBirth(dob);

    boolean onBudget = InputHelper.getBooleanInput("Is on budget? ");
    student.setOnBudget(onBudget);


    StudentManager.update(student);