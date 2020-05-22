BCookieAuthenticator cookieAuth1 = new BCookieAuthenticator(getContext(), false, false);
cookieAuth1.setNext(InvoiceInstallmentResource.class);
BCookieAuthenticator cookieAuth2 = new BCookieAuthenticator(getContext(), false, false);
cookieAuth2.setNext(ChangeStatusResource.class);

BBasicAuthenticator basicAuth = new BBasicAuthenticator(getContext(), true, false);
basicAuth.setNext(router2);

router2.attach("/v1/accounts", AccountsResource.class);
router2.attach("/v1/accounts/{id}", AccountResource.class);
router2.attach("/v1/items/{id}", ItemResource.class);
router2.attach("/v1/items", ItemsResource.class);

router1.attach("/v1/invoices/{invoice_id}/installments/{id}", cookieAuth1);
router1.attach("/v1/{object_type}/{id}/change-status", cookieAuth2);
router1.attachDefault(basicAuth);