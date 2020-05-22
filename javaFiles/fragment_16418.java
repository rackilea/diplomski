StringBuilder str = new StringBuilder();
str.append("yourstring");
for(int i = str.length()-1 ; i>=0; i--)
{
    str.append(str.charAt(i)).deleteCharAt(i);
}