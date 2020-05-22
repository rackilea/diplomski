int foo;
try {
   foo = Integer.parseInt(myString);
}
catch (NumberFormatException e)
{
   foo = 0;
}