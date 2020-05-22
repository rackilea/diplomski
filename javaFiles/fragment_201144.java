VersionHistory history = session.getWorkspace().getVersionManager().getVersionHistory("/my/node/path");
// To iterate over all versions
VersionIterator versions = history.getAllVersions();
while (versions.hasNext()) {
  Version version = versions.nextVersion();
}
// Obtain version per name
Version mySpecificVersion = history.getVersion("myVersion");
//Obtain version per label
Version labelisedVersion = history.getVersionByLabel("myLabel");
String myVersionPropertyValue = labelisedVersion.getFrozenNode().getProperty("myProperty").getString();