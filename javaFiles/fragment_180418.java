public String getChoiceString(String prompt, String s1, String s2)
{

    String s = "";
    boolean isvalid = false;
    while (true)
    {
        if(isvalid == true)
        {
            break;
        }
        //s = this.getChoiceString(prompt, s1, s2);
        //System.out.println(s);
        System.out.println("Enter your String: ");
        s = sc.nextLine();
        if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2))
        {
            System.out.println("Error! Entry must be '"+
                s1 +"', '"+ s2 +"', or '."+  "Try again.");


        }
        else
        {
            isvalid = true;
        }
    }
    return s;

}