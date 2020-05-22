val enterpriseApi = BoxDeveloperEditionAPIConnection.getAppEnterpriseConnection(boxConfig, accessTokenCache)

    // Read File Metadata
    val sharedLink = "......"
    val info = BoxItem.getSharedItem(enterpriseApi, sharedLink)

    println(s"File ID: ${info.getID}, Owener ID: ${info.getOwnedBy().getID} and name ${info.getOwnedBy().getName}")

    // Create a connection as the File owner
    val api = BoxDeveloperEditionAPIConnection.getAppUserConnection(info.getOwnedBy().getID, boxConfig)
    println(s"enterprise token ${client.connection.getAccessToken}, user token is ${api.getAccessToken}")

    // Read file as user
    val file: BoxFile = new BoxFile(api, info.getID)
    val output = new ByteOutputStream()
    file.download(output)
    println(new String(output.getBytes))