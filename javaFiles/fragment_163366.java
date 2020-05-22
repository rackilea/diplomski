@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   ...
   // Google Accounts using OAuth2
   m_credential = GoogleAccountCredential.usingOAuth2(this, Collections.singleton(DriveScopes.DRIVE));

   m_client = new com.google.api.services.drive.Drive.Builder(
            m_transport, m_jsonFactory, m_credential).setApplicationName("AppName/1.0")
            .build();
   ...
}