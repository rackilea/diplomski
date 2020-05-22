@Override
protected AndroidManifest getAppManifest(org.robolectric.annotation.Config config) {
    AndroidManifest manifest = super.getAppManifest(config);
    List<BroadcastReceiverData> broadcastReceivers = manifest.getBroadcastReceivers();
    List<BroadcastReceiverData> removeList = new ArrayList<>();
    for(BroadcastReceiverData receiverData : broadcastReceivers) {
        if(isDeletePackage(receiverData.getClassName())) {
            removeList.add(receiverData);
        }
    }
    broadcastReceivers.removeAll(removeList);
    return  manifest;
}

private boolean isDeletePackage(String className) {
    for(String s : DELETE_BROADCAST_PACKAGE) {
        if(className.startsWith(s)) {
            return true;
        }
    }
    return false;
}