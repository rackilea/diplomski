$secret = "922ec205d8e4d0ea06079d60a5336fffd9cf0aea";
$json = $secret;
$hmac_a = hash_hmac('sha256',$json,$secret);
$hmac_b = hash_hmac('sha256',$json,$secret,$raw=true); 
echo $hmac_a . "\n";
echo $hmac_b . "\n";