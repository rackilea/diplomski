try
{
    // I use the Anonymous logger here, but any named logger will work as well
    final Logger l = Logger.getAnonymousLogger();
    l.addHandler(new LevelBasedFileHandler("/tmp/info.log", Level.INFO));
    l.addHandler(new LevelBasedFileHandler("/tmp/warn.log", Level.WARNING));
    l.addHandler(new LevelBasedFileHandler("/tmp/server.log", Level.SEVERE));

    l.info("This is an INFO message");
    l.warning("This is a WARNING message");
    l.severe("This is a SEVERE message");
}
catch (final IOException e)
{
    // ignore this for this example, you should never do this in real code
}