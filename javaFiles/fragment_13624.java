URL url = getServletContext().getResource(requestUri);
if (url != null) { 
    try
    {
        Thread.sleep(100);
    } 
    catch (InterruptedException ex)
    {
        Logger.getLogger(UploadLogo.class.getName()).log(Level.SEVERE, null, ex);
    }
}