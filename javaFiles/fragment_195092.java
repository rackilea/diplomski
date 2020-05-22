public int indexOfString(String searchString, String[] domain)
 {
     for(int i = 0; i < domain.length; i++)
        if(searchString.equals(domain[i]))
           return i;

     return -1;
 }