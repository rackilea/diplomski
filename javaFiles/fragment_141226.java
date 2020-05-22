if(str.chatAt(0) == '[' && str.charAt(str.length()-1) == ']') //str.matches("\\[.*\\]")
{
    str = str.substring(1, str.length() - 1);
}
if(str.contains("[") || str.contains("]")) //str.matches(".*[\\[\\]].*")
{
    //throw your error
}