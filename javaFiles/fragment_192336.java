public static void displayArray(int tab[]){
    int i;
    String choix; // choice


    System.out.println("\n you want to see the values you entred from first position or last ?");
    System.out.println("tape \"P\" for first , and\"D\" for last);
    choix=sc1.nextLine(); // sc1 for nextLine , sc for nextInt to avoid buffering problems .

    if(choix.equals("p")||choix.equals("P")) 
    {    for(i=0;i<k;i++)      //k is the maximum of the array(max index)
        System.out.println("T["+i+"]= "+tab[i]); // why this instruction doesn't work ?? 
        //Your code did not even reach this point due to using unescape quotes inside a String and incorrect comparisons in your if

    }

    if(choix.equals("D")||choix.equals("d"))
    {for(i=k-1;i>=0;i--)
        System.out.println("T["+i+"]= "+tab[i]);// this one too doesn't work
        //The reason is the very same as above

    }}      


     public static void main(String[] args) {
        // TODO Auto-generated method;stub
         int tab[]=new int[4];

         System.out.println(readIntArray(tab));
         displayArray(tab);
    }    
}