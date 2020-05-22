ClusterDasFailoverLevelAdvancedRuntimeInfo clusterDasFailoverLevelAdvancedRuntimeInfo = null;
try {
final Argument[] paras = new Argument[1];
paras[0] = new Argument("_this", "ManagedObjectReference", clusterComputeResource.getMOR());

clusterDasFailoverLevelAdvancedRuntimeInfo = (ClusterDasFailoverLevelAdvancedRuntimeInfo) serviceInstance.getServerConnection().getVimService().getWsc().invoke("RetrieveDasAdvancedRuntimeInfo", paras, "ClusterDasFailoverLevelAdvancedRuntimeInfo");
} catch (final Exception e) {
//error handling
}