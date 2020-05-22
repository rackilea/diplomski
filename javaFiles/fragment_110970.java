GitkitClient gitkitClient = GitkitClient.newBuilder()
      .setGoogleClientId("your-oauth2-web-client-id-at-Google")
      .setServiceAccountEmail("your-service-account-email-at-Google-developer-console")
      .setKeyStream(new FileInputStream("path-to-your-service-account-private-file"))
      .build();
gitkitClient.deleteUser("test-user-id");