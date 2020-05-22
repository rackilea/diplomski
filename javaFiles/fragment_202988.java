try
{
    URI uri = new URI("http://google.com/");
    Desktop dt = Desktop.getDesktop();
    dt.browse(uri);
}
catch(Exception ex){}