ProcessBuilder pb = new ProcessBuilder(
            "curl",
            "https://mysharepoint/_api/web/lists/getbytitle('listName')/items",
            "-v",
            "--ntlm",
            "--negotiate",
            "-u",
            "user:password"
    );

    Process p = pb.start();
    InputStream is = p.getInputStream();
    return createHashMapForStaff(convertStreamToString(is));