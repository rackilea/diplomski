if (DeviceInfo.isSimulator()) {
    urlPath += ";deviceside=true";
} else {
    urlPath += connectionDependentSuffix; // suffix that is relevant to
                                          // the desired connection option
}
c = (HttpConnection)Connector.open(urlPath);