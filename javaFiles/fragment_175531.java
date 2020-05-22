public class DeployPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getPlugins().apply("org.hidetake.ssh");
        org.hidetake.groovy.ssh.core.Service ssh = project.getExtensions().getByType(org.hidetake.groovy.ssh.core.Service.class);
        ssh.settings(new MethodClosure(this, "configureSettingsClosure"));
    }

    private void configureSettingsClosure(org.hidetake.groovy.ssh.core.settings.GlobalSettings settings) {
        settings.setIdentity(ssh_file);
        settings.setKnownHosts(settings.getAllowAnyHosts());
        settings.setPassphrase("p@ssw0rd");
    }