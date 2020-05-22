offset = alphabet.indexOf(temp);
offset -= shift;
if(offset > 25)
{
    newOffset = offset % 26;
    sb.append(alphabet.charAt(newOffset));
}
else
{
    sb.append(alphabet.charAt(offset));//< New offset is less than 0
}