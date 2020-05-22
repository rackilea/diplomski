String list = ""; 
for (String element : array) {
    if (list.length > 0) 
        list += ", ";
    list += element;
}

return list;