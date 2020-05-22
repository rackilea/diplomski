public boolean validateLicense() 
{
boolean retValue = false;
if ((this.licenseNumber.matches("^[a-zA-Z]{2}\\d{7}$")))
    retValue = true;
return retValue;
}