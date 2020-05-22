if(red.equals(x) && yellow.equals(y) || red.equals(y) && yellow.equals(x))//if red&yellow selected
    return "orange";
else if(red.equals(x) && blue.equals(y) || red.equals(y) && blue.equals(x))//if red&blue selected
    return "purple";
else if(yellow.equals(x) && blue.equals(y) || yellow.equals(y) && blue.equals(x))//if blue&yellow selected
    return "green";
else
    return null;  // default value, if neither orange nor purple nor green