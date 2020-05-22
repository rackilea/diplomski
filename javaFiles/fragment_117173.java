$user     = 'user\\name';
$pass     = 'password!';  
$userpass =  base64_encode($user.':'.$pass);
$url      = 'http://www.thingsandstuff.com:8080/restfulness/post';  

if (($handle = fopen("foo.csv", "r")) !== FALSE) 
{
    while (($data = fgetcsv($handle, 1000, ",")) !== FALSE) 
    { 
        list($thing1,$thing2) = $data;

        $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>
        <entry xmlns=\"http://purl.org/atom/ns#\"> 
            <xml data goes here>
                <ns:thing1>$param1</ns:thing1>
                <ns:thing2>$param2</ns:thing2>
            </xml data goes here>
        </entry>";

        $datums = 'data='.utf8_decode($xml);
        $result = do_curl($url,$datums); 

        // not actually using the response at this
        // point... just running through everything 
        var_dump($result); 
    }
    fclose($handle);
} 

function do_curl($url, $data) {  
    global $userpass, $user, $pass; 

    $ch = curl_init(); 

    $header = array('Authorization:'.$userpass,
                    'Content-Type:application/x-www-form-urlencoded',
                    'Content-Length:'.strlen($data)); 

    // this line was the last thing to be added before it worked
    // i didn't try it again, removing the authentication in $header
    // to see if this was the only thing actually needed...  
    curl_setopt($ch, CURLOPT_USERPWD, $user.':'.$pass); 

    curl_setopt($ch, CURLOPT_URL, $url);  
    curl_setopt($ch, CURLOPT_HEADER, $header); 
    curl_setopt($ch, CURLINFO_HEADER_OUT, true); 
    curl_setopt($ch, CURLOPT_NOBODY, true); 
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); 
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $data);

    $result = curl_exec($ch); 

    $status = curl_getinfo($ch, CURLINFO_HTTP_CODE);
    $hout   = curl_getinfo($ch, CURLINFO_HEADER_OUT);

    //echo "\n"; var_dump($hout); echo "\n"; 

    curl_close($ch); 

    return array('status'=>$status, 'result'=>$result);  
}