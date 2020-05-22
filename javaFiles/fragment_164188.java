int parseResult = 0;
try 
{
  parseResult = Integer.parseInt(form.getNoOfStudents());
}
catch (NumberFormatException e)
{
  e.printStackTrace(); // just show exception text, don't interrupt program
} 

// now if form.getNoOfStudents() was incorrect string which can't be converted to int
// parse result will be 0 and message in console, else if no errors it will contain
// valid parsed value
if(count<parseResult) 
{
   e.reject("errors.availableStudents", new Object[] { count }, null);
}