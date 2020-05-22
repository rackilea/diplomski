public static void main( String[] args ) throws Exception
{
    JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog( null );

    switch ( returnValue )
    {
    case JFileChooser.APPROVE_OPTION:
        System.out.println( "chosen file: " + fileChooser.getSelectedFile() );
        break;
    case JFileChooser.CANCEL_OPTION:
        System.out.println( "canceled" );
    default:
        break;
    }
}