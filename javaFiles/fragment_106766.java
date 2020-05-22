... }      
if(currChar.equals("["))
{          
 myStackRef.push("[");         
}         
if(currChar.equals("}") && myStackRef.peek().equals("{"))
{            
 myStackRef.pop();           
}       
if(currChar.equals(")") && myStackRef.peek().equals("("))
{         
 myStackRef.pop();      
}            
if(currChar.equals("]") && myStackRef.peek().equals("["))
{
  myStackRef.pop();         
}       
}       

if(myStackRef.isEmpty())
{
  System.out.println("Balanced"); 
}
else
{  
  System.out.println("Unbalanced");         
   }    
}  
}