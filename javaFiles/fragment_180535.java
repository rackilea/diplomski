public String didentifier(String cat)
{
    try
    {
        if( cat.equals("Government") )
              s = new Scanner( new File("ugov.dat") );
        else
              s = new Scanner( new File("uhc.dat") );
        //Some Statements
    }catch( FileNotFoundException e ) {
            System.out.println( "Exception : " + e );
    }
//your Return here...
}