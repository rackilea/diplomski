{
  "realm": "FocusocKeycloak",
  "auth-server-url": "http://{param_keycloak_server}:8080/auth",
  "ssl-required": "external",
  "resource": "login-app",
  "verify-token-audience": true,
  "credentials": {
    "secret": "XXX"
  },
  "confidential-port": 0,
  "policy-enforcer": {}
}