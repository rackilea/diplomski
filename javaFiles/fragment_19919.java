String searchStr= search.getText();
    for(int i = 0; i < searchStr.length(); i++)
    {
        char a;
        a = searchStr.charAt(i);
        if(!(a >= '0' && a <= '9') || !(a == '#') || !(a == '*')
        {
             searchStr = searchStr.replace(Character.toString(a), "");
        }
    }
    search.setText(searchStr);