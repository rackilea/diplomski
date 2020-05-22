private Boolean validationSuccess(String value)
{
    if(!value.equals("VISTEON"))
    {
        alertDialog();
        return false;
    }

     return true;
 }