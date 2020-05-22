public static final String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=account-name;AccountKey=account-key";

public String getAccountSASToken() throws InvalidKeyException, URISyntaxException, StorageException {

    CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);

    SharedAccessAccountPolicy policy = new SharedAccessAccountPolicy();
    policy.setPermissions(EnumSet.of(SharedAccessAccountPermissions.READ, SharedAccessAccountPermissions.WRITE, SharedAccessAccountPermissions.LIST));
    policy.setServices(EnumSet.of(SharedAccessAccountService.BLOB, SharedAccessAccountService.FILE) );
    policy.setResourceTypes(EnumSet.of(SharedAccessAccountResourceType.SERVICE));
    policy.setSharedAccessExpiryTime(Date.from(ZonedDateTime.now(ZoneOffset.UTC).plusHours(24L).toInstant()));
    policy.setProtocols(SharedAccessProtocols.HTTPS_ONLY);

    return account.generateSharedAccessSignature(policy);
}