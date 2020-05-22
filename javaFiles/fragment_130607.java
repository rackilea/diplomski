private void Process(boolean Success)
{
    if(Success)
    {               
        appHelper.CreateAlert("Success!", "Well Done!");

     }
    else
    {
        appHelper.CreateAlert("Failure!", "Please try again.");
    }
}