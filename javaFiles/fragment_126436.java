public class LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

@Override
public void launch(ILaunchConfiguration configuration, String mode,
        ILaunch launch, IProgressMonitor monitor) throws CoreException {


    // skipped some argument processing

    envp[idx++] = "JAVA_HOME=" + System.getProperty("java.home");         
    envp[idx++] = "M2_HOME=" + System.getenv("MAVEN_HOME");

    String[] cmds = {};
    cmds = cmdLine.toArray(cmds);
    // Launch a process to run/debug. See also #71 (output is less or no output)
    Process p = DebugPlugin.exec(cmds, workingPath, envp);
    // no way to get private p.handle from java.lang.ProcessImpl
    RuntimeProcess process = (RuntimeProcess)DebugPlugin.newProcess(launch, p, Constants.PROCESS_MESSAGE);