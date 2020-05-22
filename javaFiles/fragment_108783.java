$nvps = array();
$nvps["VERSION"] = "80.0";

$nvps["METHOD"] = "SetExpressCheckout";

$nvps["PAYMENTREQUEST_0_PAYMENTACTION"] = "Sale";
$nvps["PAYMENTREQUEST_0_AMT"] = "1.00";
$nvps["PAYMENTREQUEST_0_CURRENCYCODE"] = "GBP";
$nvps["PAYMENTREQUEST_0_ITEMAMT"] = "1.00";

$nvps["L_BILLINGTYPE0"] = 'RecurringPayments';
$nvps["L_BILLINGAGREEMENTDESCRIPTION0"] = "the subscription";

$nvps["L_PAYMENTREQUEST_0_NUMBER0"] = 1;
$nvps["L_PAYMENTREQUEST_0_NAME0"]= "subscription";
$nvps["L_PAYMENTREQUEST_0_AMT0"]= 1.00;
$nvps["L_PAYMENTREQUEST_0_QTY0"]= 1;