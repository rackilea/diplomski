if (this.authenticationService.authenticationExists(userName) == false)
{
   this.authenticationService.createAuthentication(userName, password.toCharArray());

   PropertyMap ppOne = new PropertyMap(4);
   ppOne.put(ContentModel.PROP_USERNAME, userName);
   ppOne.put(ContentModel.PROP_FIRSTNAME, "firstName");
   ppOne.put(ContentModel.PROP_LASTNAME, "lastName");
   ppOne.put(ContentModel.PROP_EMAIL, userName+"@example.com");
   ppOne.put(ContentModel.PROP_JOBTITLE, "jobTitle");

   this.personService.createPerson(ppOne);
}