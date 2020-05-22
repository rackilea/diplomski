String path() :
{String path = "";
Token slash = null;
Token id = null;}
{
  (slash = < SLASH > ( id = < IDENTIFIER >)
  {
    path += slash.toString() + id.toString();
  })+
  {
    return path;
  }  
}