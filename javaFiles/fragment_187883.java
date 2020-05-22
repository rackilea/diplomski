String s = "";
boolean isComma = true; // true = comma, false = space.
for (Thing thing : things)
{
    if (things.getCategory() == thing.STUFF)
    {
        //Check if there already exists an entry within the String.
        if (s.length() > 0)
        {
            //Add comma or space as required based on the isComma boolean.
            if (isComma)
            {
                s += ", ";
            }
            else
            {
                s += " ";
            }
        }
        s += thing.getName();
    }
}

if (s.equals(""))
{
    s += "nothing";
}
return s;