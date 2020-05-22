public static void main(String[] args)
  {   
      arr = new int[] {4,8,3,15,2,21,6,19,11,7};
      SortArr ob=new SortArr();
      int[] newSol = ob.correctfunction(arr);
      int[] newAns = ob.sortin(arr); 

      if(Arrays.equals(newSol, newAns))
          System.out.println("correct");
      else
          System.out.println("incorrect");
  }