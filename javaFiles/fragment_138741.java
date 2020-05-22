// Generate key for keystore
String userStore = username + "KeyStore.jks";
String userDetails = "CN=" + username
        + ", OU=FCT, O=UNL, L=Unknown, ST=Unknown, C=PT";
String certValidity = "" + 365;
String keytoolArgs[] = { "keytool", "-genkeypair", "-alias",
        username, "-keystore", "Client/" + userStore,
        "-keypass", certpassword, "-storepass", certpassword,
        "-keyalg", "RSA", "-keysize", "2048", "-dname",
        userDetails, "-validity", certValidity };
System.out.println(Arrays.asList(keytoolArgs));
Process p1 = Runtime.getRuntime().exec(keytoolArgs);
p1.waitFor();