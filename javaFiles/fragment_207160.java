int NumberNames(String wholename)
{
    String testname=wholename;
    int numnames=1;
    int posBlank= testname.indexOf(' ');

    while(posBlank > 0)
    {   
       testname = testname.trim();
       testname=testname.substring(posBlank+1,testname.length());
       posBlank= testname.indexOf(' ');
       numnames++;
       System.out.println(testname);
    }    

    return numnames;
}