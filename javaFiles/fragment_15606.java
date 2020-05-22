StringBuffer list = new StringBuffer(); 
for (String element : array) {
    if (list.length() > 0) 
        list.append(", ");
    list.append(element);
} 

 return list.toString();