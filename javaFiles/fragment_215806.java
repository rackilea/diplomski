public class Dygraph extends WebPage {
    public Dygraph() {
        String csv = "Date,ms\n20070101,62\n20070102,62";
        ResourceLink<File> link = new ResourceLink<File>("csv", new ByteArrayResource("text/csv", csv.getBytes()));
        add( link );

        //this is the url that should be passed to the javascript code
        CharSequence url = link.urlFor( IResourceListener.INTERFACE ); 

        add(new Label("graphdiv").add(new DygraphBehavior()));
    }
}