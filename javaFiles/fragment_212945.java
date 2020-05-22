public ListBoxModel doFillOperatingSystemItems(
    @QueryParameter String operatingSystem
) {
    return new ListBoxModel(
        new Option("rhel", "rhel", operatingSystem.matches("rhel") ),
        new Option("linux", "linux", operatingSystem.matches("linux") ) 
    );
}