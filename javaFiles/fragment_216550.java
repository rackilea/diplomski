String temp_content = null;

while((line = br.readLine())!= null)
{   
    if(temp_content == null)
    {
     temp_content = line;
    }
    else
    {
        temp_content += line;
    } 
}