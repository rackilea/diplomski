public class DeployPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getPlugins().apply("org.hidetake.ssh");
        Object ssh = project.getExtensions().getByName("ssh");
        try {
            Method settings = ssh.getClass().getDeclaredMethod("settings", Closure.class);
            settings.invoke(ssh, new MethodClosure(this, "configureSettingsClosure"));
        } catch (IllegalAccessException | NoSuchMethodException e) {
            throw new AssertionError("Should not happen except by using a different groovy-ssh version that changed incompatibly", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void configureSettingsClosure(Object settings) throws InvocationTargetException {
        try {
            Method setIdentity = settings.getClass().getDeclaredMethod("setIdentity", Object.class);
            setIdentity.invoke(settings, ssh_file);
            Method getAllowAnyHosts = settings.getClass().getDeclaredMethod("getAllowAnyHosts");
            Method setKnownHosts = settings.getClass().getDeclaredMethod("setKnownHosts", File.class);
            setKnownHosts.invoke(settings, getAllowAnyHosts.invoke(settings));
            Method setPassphrase = settings.getClass().getDeclaredMethod("setPassphrase", String.class);
            setPassphrase.invoke(settings, "p@ssw0rd");
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new AssertionError("Should not happen except by using a different groovy-ssh version that changed incompatibly", e);
        }
    }