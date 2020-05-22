play.ws.ssl {
  trustManager = {
    stores = [
      {path: "C:/A/B/jssecacerts"}
      {path: ${java.home}/lib/security/cacerts}
    ]
  }
}