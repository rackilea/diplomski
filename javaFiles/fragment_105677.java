public String seeColor(String str)
{
    if(str == null) return "";
    else if(str.startsWith("red")) return "red";
    else if(str.startsWith("blue")) return "blue";
    else return "";
}