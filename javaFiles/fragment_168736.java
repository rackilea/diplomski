OAuth2ClientOptions optsDisc = new OAuth2ClientOptions();
opts.setClientID("{client-id}");
AzureADAuth.discover(vertx, opts,res -> {
if (res.succeeded()) {
//use res.result() to access the through discovery already created OAuth2Auth Object
log.debug("Discover succeeded.");
} else {
log.error("Discover failed.");
}
})