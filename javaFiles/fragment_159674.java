if( Desktop.isDesktopSupported() )
{
    new Thread(() -> {
           try {
               Desktop.getDesktop().browse( new URI( "http://..." ) );
           } catch (IOException | URISyntaxException e1) {
               e1.printStackTrace();
           }
       }).start();
}