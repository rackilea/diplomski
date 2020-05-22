try
{
    final String os = System.getProperty("os.name");
    for(int i=0;i<7;i++) {
        manDrawer.drawMan(i);
        Thread.sleep(200);
        if (os.contains("Windows")) {
             Runtime.getRuntime().exec("cls");
         } else {
             Runtime.getRuntime().exec("clear");
         }
    }
} catch (final Exception e) {
   //  Handle any exceptions.
}