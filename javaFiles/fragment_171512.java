private void updateArtifactConfig(String appName, DeploymentConfig dc)
  throws DeploymentException {
Session session = new Session();
try {
  ObjectName[] classLoadersId = configService.resolve(session,
      "Deployment=" + appName + "\":ApplicationDeployment:WebModuleDeployment:");

  AttributeList attrList = new AttributeList();
  AttributeList clList = (AttributeList)configService.getAttribute(session, classLoadersId[0],
      "classloader");
  ConfigServiceHelper.setAttributeValue(clList, "mode",
      "PARENT_LAST");
  attrList.add(new Attribute("classloader", clList));
  configService.setAttributes(session, classLoadersId[0], attrList);
  configService.save(session, true);

} catch (Exception ex) {
  LOGGER.error("Not able to update " + appName, ex);
} finally {
  try {
    configService.discard(session);
  } catch (ConfigServiceException csEx) {
    LOGGER.error("Not able to discard updateArtifact " + appName + " session", csEx);
  } catch (ConnectorException cnEx) {
    throw new DeploymentException("Unable to connect to IBM WebSphere Application Server @ "
        + dc.getHostname() + ":" + dc.getPort());
  }
}