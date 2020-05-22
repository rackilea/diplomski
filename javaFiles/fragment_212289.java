$s = curl_init(); 
curl_setopt($s,CURLOPT_URL,$this->_url);
curl_setopt($s,CURLOPT_RETURNTRANSFER,true);    
$result = curl_exec($s);
curl_close($s);
$content_arr = json_decode($result); // json data to php array.