String s = "This is multiline text that needs to be correctly parsed into key-value pairs, excluding all other information.\n" + 
        "\n" + 
        " Section One:\n" + 
        "    First key = Value One\n" + 
        "    Second key = Value Two\n" + 
        "\n" + 
        " Section Two:   \n" + 
        "    Third key = Value Three\n" + 
        "    Fourth key = Value Four\n" + 
        "    Fifth key = Value Five\n" + 
        "\n" + 
        " Section Three:\n" + 
        "    Sixth key = Value Six\n" + 
        "    Seventh key = Value Seven\n" + 
        "    Eighth key = Value Eight";
Matcher m = Pattern.compile("(?:\\r|\\n)[\\t ]*([^\\n=\\.]+)(?<=\\S)[\\t ]*=[\\t ]*(.+)").matcher(s);
while(m.find())
{
    System.out.println("Key : "+m.group(1) + " => Value : " + m.group(2));
}