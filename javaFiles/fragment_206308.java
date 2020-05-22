public void foo() throws OwnExceptionAboutTechnicalError {
    // ...       

    if(somethingBadHappens) 
    {
        throw new OwnExceptionAboutTechnicalError("Something bad happened");
    }

    // ...       
}