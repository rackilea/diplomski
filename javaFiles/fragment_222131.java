bool tag = false;
string str = "";
List<string> htmlTags = new List();

for(int i = 0; i < array.length; i++)
{ 
  //Check for the start of a tag
  if(array[i] == '<')
  {
    tag == true;
  }

  //If the current char is part of a tag start copying
  if(tag)
  {
    str += char;
  }

  //When a tag ends add the tag to your tag list
  if(array[i] == '>')
  {
    htmlTags.Add(str);
    str = "";
    tag == false;
  }
}