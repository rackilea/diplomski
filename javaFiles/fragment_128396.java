@SuppressWarnings("unchecked")
@Override
public Descriptor<ConfigLink> getDescriptor() {
    Jenkins jenkins = Jenkins.getInstance();
    if (jenkins == null) {
        throw new IllegalStateException("Jenkins has not been started");
    }
    return jenkins.getDescriptorOrDie(getClass());
}