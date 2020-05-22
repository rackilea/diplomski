public void myJobFailingMethod()
{
    if(conditionsMatch())
    {
        throw new CustomJobFailingException(); // create this exception class.
                                               // It will fail the job.
    }  
}