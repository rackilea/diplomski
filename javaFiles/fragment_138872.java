$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, 'http://www.example.com/webservice');
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query(array('foo'=>'bar','baz'=>1)));
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_HEADER, 0);
$result = curl_exec($ch);