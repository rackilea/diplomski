Iterator<> it = al1.iterator();
while(it.hasNext()){
     temp = it.next();  
     if (temp.charAt(0)=='-'|| (Character.isDigit(temp.charAt(0))==false))
       {
           it.remove();    
       }  
}