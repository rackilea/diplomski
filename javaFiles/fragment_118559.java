if(Character.isWhitespace(ch))
{
    spaces++;
}
else{
if(spaces>=1)
{ spaces=0;
fos.write(' ');
fos.write(ch);}