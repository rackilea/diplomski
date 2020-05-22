final FileHandler infoFileHandler = new FileHandler("/tmp/info.log");
infoFileHandler.setFilter(new Filter()
{
    public boolean isLoggable(final LogRecord logRecord)
    {
        return logRecord.getLevel().equals(Level.INFO);
    }
});