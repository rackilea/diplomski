student.setFirstName(InputHelper.getInput("Enter new first name: "));
  student.setLastName(InputHelper.getInput("Enter new last name: "));
  student.setDateOfBirth(InputHelper.getDateInput("Enter new date of birth: "));
  student.setOnBudget(InputHelper.getBooleanInput("Is on budget? "));

  StudentManager.update(student);