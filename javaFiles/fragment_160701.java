while ((firstNameEmployee = br.readLine()) != null) {
    objectArray[counter] = setFirstName(firstNameEmployee);
    lastNameEmployee = br.readLine();
    objectArray[counter] = setLastName(lastNameEmployee);
    ageEmployee = Double.parseDouble(br.readLine());
    objectArray[counter] = setAge(ageEmployee);
    hourlySalaryEmployee = Double.parseDouble(br.readLine());
    objectArray[counter] = setHourlySalary(hourlySalaryEmployee);
    weeklyhoursworkedEmployee = Double.parseDouble(br.readLine());
    objectArray[counter] = setWeeklyHoursWorked(weeklyhoursworkedEmployee);
    System.out.println(objectArray[counter]);
counter++;
}