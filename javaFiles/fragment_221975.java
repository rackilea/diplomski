boolean result = false;

try
{
 // all good
 result = true;
} 
catch(...)
{
 // crap
 result = false;
}
finally
{
 // close
}
return result;