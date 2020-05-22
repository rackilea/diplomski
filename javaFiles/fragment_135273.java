for (String s : tempsArray)
    {
        String splitted[]=s.split(" ");
        int first_element=Integer.parseInt(splitted[0]);//Use this for the dimension
        int salary=Integer.parseInt(splitted[splitted.length-1].trim());//Use this as argument of a method. Here .trim() is used to remove space if its present at the end of line
    }