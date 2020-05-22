public static void checkout() {
    Double amount = Double.parseDouble(session.get("amount"));
    Long userId = Long.parseLong(session.get("user-id"));
    User user = User.findById(userId);
    if (user != null) {
        renderArgs.put("user", user);
    }

    // we calculate the net and gross amount with French V.A.T (19.6%)
    BigDecimal amountBD = new BigDecimal(amount * 1.196);
    BigDecimal netAmountBD = new BigDecimal(amount);
    BigDecimal taxAmountBD = amountBD.subtract(netAmountBD);

    String netAmount = netAmountBD.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString();
    String totalAmount = amountBD.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString();
    String taxAmount = taxAmountBD.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString();

    String subject="Publication d'une offre d'emploi";


// Paypal Web service callback executed by Play!  
// I have a paypal.api.server configuration property with prod and sandbox server

    WS.HttpResponse res = WS.url(Play.configuration.get("paypal.api.server").toString() +
            "&USER=%s" +
            "&PWD=%s" +
            "&SIGNATURE=%s" +
            "&VERSION=%s" +
            "&METHOD=%s" +
            "&PAYMENTREQUEST_0_PAYMENTACTION=%s" +
            "&LANDINGPAGE=%s" +
            "&SOLUTIONTYPE=%s" +
            "&EMAIL=%s" +
            "&FIRSTNAME=%s" +
            "&LASTNAME=%s" +
            "&STREET=%s" +
            "&STREET2=%s" +
            "&CITY=%s" +
            "&ZIP=%s" +
            "&STATE=%s" +
            "&PAYMENTREQUEST_0_CURRENCYCODE=%s" +
            "&MAXAMT=%s" +
            "&PAYMENTREQUEST_0_AMT=%s" +
            "&PAYMENTREQUEST_0_ITEMAMT=%s" +
            "&PAYMENTREQUEST_0_TAXAMT=%s" +
            "&PAYMENTREQUEST_0_DESC=%s" +
            "&L_PAYMENTREQUEST_0_NAME0=%s" +
            "&L_PAYMENTREQUEST_0_NUMER0=%s" +
            "&L_PAYMENTREQUEST_0_DESC0=%s" +
            "&L_PAYMENTREQUEST_0_AMT0=%s" +
            "&L_PAYMENTREQUEST_0_QTY0=%s" +

            "&NOSHIPPING=%s" +
            "&LOCALECODE=%s" +
            "&RETURNURL=%s" +
            "&CANCELURL=%s" +
            "&ADDROVERRIDE=%s" +
            "&BRANDNAME=%s"
            ,
            //-------
            Play.configuration.get("paypal.api.username").toString(),
            Play.configuration.get("paypal.api.password").toString(),
            Play.configuration.get("paypal.api.signature").toString(),
            "69.0", // API Version
            "SetExpressCheckout", //Method
            "Sale",
            "Billing",
            "Sole",
            user.email,
            "" + user.fullname,
            "" + user.fullname,
            "" + user.postalAddress,
            "" + user.postalAddress2,
            "" + user.city,
            "" + user.zip,
            "None",
            "EUR",
            totalAmount, //MaxAMT
            totalAmount, //amount.toString()
            netAmount, //PAYMENTREQUEST_n_ITEMAMT
            taxAmount,
            subject,
            //---------
            "Item name",
            "1",
            subject,
            netAmount,
            "1",
            //---------
            "1",
            "FR",
            Play.configuration.get("paypal.returnUrl").toString(),
            Play.configuration.get("paypal.cancelPay").toString(),
            "1", //ADDROVERRIDE
            "eXpress-Board pour Innoteria"
    ).get();


    String message = res.getString();
    PaypalResponse paypalResponse = new PaypalResponse(message);
    if (paypalResponse.isSuccess()) {
        Payment payment = new Payment();
        payment.userId = user.id;
        payment.totalAmount = totalAmount;
        payment.netAmount = netAmount;
        payment.taxAmount = taxAmount;
        payment.token = paypalResponse.getToken();
        payment.correlationID = paypalResponse.getCorrelationID();
        payment.save();

        redirect(Play.configuration.get("paypal.api.http").toString() + "/cgi-bin/webscr?cmd=_express-checkout&token=" + paypalResponse.getToken());
    }

    Logger.error("Error on SetExpressCheckout with: ");
    for (String tokens : message.split("&")) {
        try {
            Logger.error(URLDecoder.decode(tokens, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }
    }

    error("Error from Paypal");

}