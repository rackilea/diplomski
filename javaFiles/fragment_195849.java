public static void main( String[] args )
{
    Scanner scan = new Scanner( System.in );

    boolean validSelection = false;

    do
    {
        System.out.println( "Please pick an option from the menu above" );
        char option = scan.next().charAt( 0 );
        switch( option )
        {
            case 'a':
                break;
            case 'b':
                break;
            case 'c':
                break;
            case 'd':
                break;
            case 'e':
                break;
            case 'f':
                break;
            case 'q':
                validSelection = true;
                break;
            default:
                System.out.println( "Choice invalid." );
                break;
        }
    }
    while( validSelection == false );
}
}