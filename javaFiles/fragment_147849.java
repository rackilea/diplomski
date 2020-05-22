public void onradioButtonClicked ()
{
   if (ButtonClicked() == opt1)
   {
      txtTextField2.Enabled = false;
      txtTextField1.Enabled = true;
   }
   else
   {
      txtTextField2.Enabled = true;
      txtTextField1.Enabled = false;
   }
}