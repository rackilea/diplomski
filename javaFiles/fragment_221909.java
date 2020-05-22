private static  Logger   logger = Logger.getLogger("UploadFiles");
@POST
@Path("savefile")
public void createObjects(@Context HttpServletRequest request)
{
    try
    {
        FileHandler f;
        f = new FileHandler(new File (getClass().getResource("/" +getClass().getName().substring(
                0, getClass().getName().indexOf("."))).getPath()).getParent().replaceAll("\\\\", "\\\\\\\\")  + "/mylog.log");
        logger.addHandler(f);

    }
    catch (SecurityException e1)
    {
        logger.info(e1.getMessage());

    }
    catch (IOException e1)
    {
        logger.info(e1.getMessage());
    }
    ApplicationConstants.ROOTPATH = new File (getClass().getResource("/" +getClass().getName().substring(
            0, getClass().getName().indexOf("."))).getPath()).getParent().replaceAll("\\\\", "\\\\\\\\") ;
    ApplicationConstants.ROOTPATH = ApplicationConstants.ROOTPATH.substring
    (0, ApplicationConstants.ROOTPATH.indexOf("\\") + 2);
    String user = request.getParameter("username");
    logger.info("ApplicationConstants.ROOTPATH" + ApplicationConstants.ROOTPATH);
    logger.info("username" + user);
    try
                {
        for (Part part : request.getParts())
        {

                    logger.info("part = " + part.getName());
                    if (!part.getName().equalsIgnoreCase("username"))
                    {
                        try {
                        BufferedInputStream in = new BufferedInputStream(part.getInputStream());
                        String filename = getFilename(part);
                        boolean success = (new File(ApplicationConstants.ROOTPATH + user + "\\")).mkdir();
                        if (success) {
                        System.out.println("Directory: " + ApplicationConstants.ROOTPATH + user .trim()+ "\\" + " created");
                        }  
                        else
                        {
                            System.out.println("not created");
                        }
                        FileOutputStream out = new FileOutputStream(ApplicationConstants.ROOTPATH + user  + "\\" + filename);

                        byte[] data = new byte[1000];
                        int bytesRead = 0;
                        int offset = 0;
                        while (offset < part.getSize())
                        {
                          bytesRead = in.read(data);
                          if (bytesRead == -1)
                          {
                              break;
                          }
                          offset += bytesRead;
                           out.write(data);
                        }

                        in.close();

                        if (offset != part.getSize())
                        {
                          throw new IOException("Only read " + offset + " bytes; Expected " + part.getSize() + " bytes");
                        }
                        out.flush();
                        out.close();
                        }
                        catch (Exception e) 
                        {
                            logger.info(e.getMessage());
                        }
                    }
                    else
                    {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
                        StringBuilder value = new StringBuilder();
                        char[] buffer = new char[1024];
                        reader.read(buffer);
                        value.append(buffer);
                         user = value.toString().trim();
                         logger.info("user = " + value);
                    }

}
    }
    catch (IOException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (ServletException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}