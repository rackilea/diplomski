int replacements = 0;
for (int i=0; i < front.length(); ++i)
{
    int backIndex = back.length() - i;
    if (front.charAt(i) != back.charAt(backIndex))
    {
        // Characters do not match at all to given replacement
        if ((front.charAt(i) != replacement) &&
            (back.charAt(backIndex) != replacement)
        {
            // Cannot make it 
            // (Or if you want to force it, set both to replacement
            //  by deleting this one if statement)
            return false;
        }
        // Front matches replacement
        else if (front.charAt(i) == replacement)
        {
            // Replace back character with replacement
            back.setCharAt(backIndex, replacement);
            replacements++;
        }
        // Back matches replacement
        else if (back.charAt(backIndex) == replacement)
        {
            // Replace front character with replacement
            front.setCharAt(i, replacement);
            replacements++;
        }
        if (replacements > 1)
        {
            // Can only replace one
            return false;
        }
    }
}

String output = front.toString() + back.toString();