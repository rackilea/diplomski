/**
 * @author swoeste
 * 
 */
public class MavenExecutor {

private final File       configuration;
private final ClassWorld classWorld;

/**
 * Constructor for a new maven executor.
 * 
 * @param aConfiguration
 */
public MavenExecutor( final File aConfiguration ) {
    this.configuration = aConfiguration;
    this.classWorld = new ClassWorld( "plexus.core", this.getClass().getClassLoader() ); //$NON-NLS-1$
}

/**
 * This method is used to perform a mvn  command on the given pom. The original
 * command must be given, also the sub folder and the marker folder in the working directory. The working directory
 * and the configuration file will be added before execution.
 * 
 * @param cmd the mvn command to execute
 * @param pom the absolute path to a maven pom file
 * @param output the absolute path to the working directory
 * @param folder the output sub folder of the working directory
 * @param marker the marker sub folder of the working directory
 * @return
 */
public int unpack( final String cmd, final File pom, final File output, final String folder, final String marker ) {
    final List<String> commands = new ArrayList<String>( //
            Arrays.asList( cmd.split( ConfigurationConstants.MAVEN_DELIMITER ) ) );
    commands.add( "-DoutputDirectory=" + output.getAbsolutePath() + folder ); //$NON-NLS-1$
    commands.add( "-DmarkersDirectory=" + output.getAbsolutePath() + marker ); //$NON-NLS-1$
    commands.add( "-gs=\"" + this.configuration.getAbsolutePath() + "\"" ); //$NON-NLS-1$//$NON-NLS-2$
    commands.add( "-f=\"" + pom.getAbsolutePath() + "\"" ); //$NON-NLS-1$ //$NON-NLS-2$
    return MavenCli.doMain( commands.toArray( new String[commands.size()] ), this.classWorld );
}