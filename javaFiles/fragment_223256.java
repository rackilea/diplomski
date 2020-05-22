public String[] getForm()
{
    formReturn = formArray; /* (0) */
    formReturn[0] = formArray[0];
    for(int i = 1; i < formReturn.length; i++)
        formReturn[i] = text[i].getText(); /* (1) */
    return formReturn;
}