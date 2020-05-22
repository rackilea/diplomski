if( context == null )
        throw new WMSException( "Missing session context." );

    String path  = context.getRealPath("");
    if( path == null )
        throw new WMSException( "Missing context real path." );

    LOGGER.info( "Path 1 '" + path + "'");

    WebSocket ws    = new WebSocket();
    String    sep   = "/";
    int       where = path.lastIndexOf( sep );
    if( where < 0 ){
        sep   = "\\";
        where = path.lastIndexOf( sep );
    }

    String newPath  = path.substring( 0, where );
    if( newPath.equals(path.substring(0, path.length() - 1 )))
    {
        where = newPath.lastIndexOf( sep );
        path  = newPath.substring( 0, where );
        LOGGER.info( "Path 2a '" + path + "'");
    }
    else
        path = newPath;

    LOGGER.info( "Path 2 '" + path + "'");
    where = path.lastIndexOf( sep );
    path  = path.substring( 0, where ) + "/conf/wms";
    LOGGER.info( "Path 3 '" + path + "'");
    if( firstTime ){
        firstTime = false;
        LOGGER.info( "Getting configuration from " + path );
    }

    LOGGER.info( "Path 4 '" + path + "'");
    File      docFile = new File(path, "socket.xml");
    LOGGER.info( "Name '" + docFile.getName() + "';Path '" + docFile.getPath() + "'");