@Test(expected = javax.faces.validator.ValidatorException.class)
public void testValidatorWithExistedMailId(@Mocked FacesContext faces) {
    EmailIdExistanceValidator emailExistanceValidator=new EmailIdExistanceValidator();
    UIComponent uiComponent=null;
    emailExistanceValidator.validate(faces, uiComponent, "exitedId@gmail.com");
    assertNotNull(FacesMessage.VALUES);
}

@Test()
public void testValidatorWithUnExistedMailId(@Mocked FacesContext faces,@Mocked FacesMessage msg) {
    EmailIdExistanceValidator emailExistanceValidator=new EmailIdExistanceValidator();
    UIComponent uiComponent=null;
    emailExistanceValidator.validate(faces, uiComponent, (Object)"unexitedId@gmail.com");
    assertNotNull(FacesMessage.VALUES);
}