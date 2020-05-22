public class TestCat
{ 
  public static void main(String [] args)
  { 

    Cat[] cats = new Cat[10];    
    Vector catsUnlimited = new Vector(10);    
    Cat myCat = null;

    for (int i=1; i<11; i++)
    {     
    myCat = new Cat("Cat" + i); 
      cats[i-1]= myCat; 

      catsUnlimited.addElement(new Cat("Cat" + i));

      System.out.println("My cat is:  " + cats[i-1] ); 
    }

    System.out.println("Known cats");
    for (int x = 0; x < catsUnlimited.size(); x++)
    {        
     System.out.println("Cat #" + (x+1) + ":" +(Cat)catsUnlimited.get(x));
    }    
  } 
}