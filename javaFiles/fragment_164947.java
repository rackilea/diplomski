# WARNING : maybe you should provide your context in the URL : provide the same URL that you use in your browser for example
$url = "http://127.0.0.1:12111";
#provide your parameters like : ?param1=value1&param2=value2&.....&paramN=valueN
$post_params_s = "" ;

$ch  = curl_init ( $url ) ;
curl_setopt ( $ch, CURLOPT_POST          , TRUE ) ;
curl_setopt ( $ch, CURLOPT_POSTFIELDS    , $post_params_s ) ;
curl_setopt ( $ch, CURLOPT_RETURNTRANSFER, TRUE ) ;             // -- put it to FALSE, write directly in main output
curl_exec   ( $ch ) ;
curl_close  ( $ch ) ;