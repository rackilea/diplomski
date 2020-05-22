static ArrayList<Double> listEven = new ArrayList<Double>();

   public static void main( String args[ ] )
   {
      inputRecursion( );
      outputRecursion( );
   }

   public static void inputRecursion( )
   {
      Scanner in = new Scanner( System.in );
      if( in.hasNextDouble() )
      {
         if( (in.nextDouble() % 2) == 0 )
         {
            listEven.add( in.nextDouble() );
         }
         inputRecursion( );
      }
   }

   public static void outputRecursion( )
   {
      Iterator<Double> it = listEven.iterator();

      if( it.hasNext() )
      {
         System.out.println( it.next() );
         outputRecursion( );
      }
   }