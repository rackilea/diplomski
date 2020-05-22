@Override
public void execute()
    throws MojoExecutionException
{
    try
    {
        File outputDirectory = new File(getOutputDirectory());

        String filename = getOutputName() + ".cf";

        Locale locale = Locale.getDefault();

        ConfluenceSinkFactory factory = new ConfluenceSinkFactory();
        Sink sink = factory.createSink(outputDirectory, filename);

        generate(sink, factory, locale);
    }
    catch ( IOException e )
    {
        throw new MojoExecutionException(e);
    }
    catch ( MavenReportException e )
    {
        throw new MojoExecutionException(e);
    }
}