/**
 * Generate POJO from *.hbm.xml 
 * Example Usage: mvn prefix:hbm2pojo OR 
 *                mvn prefix:hbm2pojo -Dexec.args="com.comp.Product,com.comp.Item"
 *
 * @goal hbm2pojo
 */
public class GenerateHibernatePojoMojo extends AbstractMojo
{
    /** Directory for hibernate mapping files
     * @parameter expression="${basedir}/src/main/resources"
     * @required
     */
    private File hbmDirectory;

    /** Output directory for POJOs
     * @parameter expression="${project.build.sourceDirectory}"
     * @required
     */
    private File outputDirectory;

    /** set to true if collections need to use generics. Default is false.
     * @parameter expression="${jdk5}" default-value="false"
     * @optional
     */
    private String jdk5;

    public void execute() throws MojoExecutionException, MojoFailureException
    {
        POJOExporter exporter = new POJOExporter();
        exporter.setOutputDirectory( outputDirectory );

        Configuration config = new Configuration();
        config.setProperty("jdk5", jdk5);

        String args = System.getProperty("exec.args");
        if (args != null && !"".equals(args))
        {
            String[] entityNames = args.split(",");
            for(String entityName : entityNames)
            {
                File hbmFile = new File( hbmDirectory + "/" + entityName.replace( '.', '/' ) + ".hbm.xml" );
                config.addFile( hbmFile );
            }
        }
        else
        {
            config.addDirectory( hbmDirectory );
        }
        exporter.setConfiguration( config );
        exporter.start();
        // TODO this guy also generates unwanted POJOs like POJO of component
        // TODO Add support for Java 5 Generic
    }

}