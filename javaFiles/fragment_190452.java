//Arrange
location = Location.EUROPE;
Person person = mock(Person.class);

//Act
emailService.sendEmail(person, location);

//Assert
//...