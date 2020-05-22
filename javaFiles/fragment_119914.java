<?php 

require_once 'oauth.php';

$key = 'consumerKey';
$secret = 'secretKey';
$consumer = new OAuthConsumer($key, $secret);

$api_endpoint = 'http://localhost:9998/oauth';
$sig_method = new OAuthSignatureMethod_HMAC_SHA1;

$parameters = null;
$req = OAuthRequest::from_consumer_and_token($consumer, null, "GET", $api_endpoint, $parameters);
$sig_method = new OAuthSignatureMethod_HMAC_SHA1();
$req->sign_request($sig_method, $consumer, null);//note: double entry of token

//get data using signed url
$ch = curl_init($req->to_url());
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
$res = curl_exec($ch);

echo $res;
curl_close($ch);