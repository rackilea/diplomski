SharedAccessSignature s = new SharedAccessSignature.SasBuilder()
    .signedPermission("rwd")
    .signedStart("2018-01-31T10:48:41Z")
    .signedExpiry("2018-04-06T18:48:41Z")
    .signedVersion("2015-04-05")
    .signedResource("c")  // <<---- note here
    .canonicalizedResource("/blob/globalweb/mycontainer") // No ending slash!
    .signedProtocol("https")
    .build();