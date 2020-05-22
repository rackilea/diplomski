$ javap -cp google-api-client-1.22.0.jar com.google.api.client.googleapis.services.AbstractGoogleClient.Builder | grep set
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setRootUrl(java.lang.String);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setServicePath(java.lang.String);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setGoogleClientRequestInitializer(com.google.api.client.googleapis.services.GoogleClientRequestInitializer);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setApplicationName(java.lang.String);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setSuppressPatternChecks(boolean);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setSuppressRequiredParameterChecks(boolean);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setSuppressAllChecks(boolean);

$ javap -cp google-api-client-1.23.0.jar com.google.api.client.googleapis.services.AbstractGoogleClient.Builder | grep set
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setRootUrl(java.lang.String);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setServicePath(java.lang.String);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setBatchPath(java.lang.String);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setGoogleClientRequestInitializer(com.google.api.client.googleapis.services.GoogleClientRequestInitializer);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setApplicationName(java.lang.String);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setSuppressPatternChecks(boolean);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setSuppressRequiredParameterChecks(boolean);
  public com.google.api.client.googleapis.services.AbstractGoogleClient$Builder setSuppressAllChecks(boolean);