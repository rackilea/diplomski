//Arrange
location = Location.EUROPE;
Person person = new Person();

//Act
emailService.sendEmail(person, location);

//Assert
//...