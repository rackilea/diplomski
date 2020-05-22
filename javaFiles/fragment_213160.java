ClassEmployer Employer;                     

String sText="";
try
{       
    //Infinit reading
    while(true)
    {
        //that code wil have crashed with an EOFEXception
        Employer = (ClasseEmployer)objetoInStr.readObject();
        sText=sText+"Name: " + Employer.getName() + " Salary: "+ Employer.getSalary() +"\n";
    }   
}
catch(EOFException ex)
{
    objetotextoGrande.setText(sText);
}