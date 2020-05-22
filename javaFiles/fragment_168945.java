Optional<String> result = choice.showAndWait();
if ( result.isPresent() )
{
    System.out.println( "button text = " + result.get() );
    System.out.println( "choice = " + choice.getSelectedItem());
}