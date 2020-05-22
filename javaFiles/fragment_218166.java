// as you are posting JSON, so tell server that you are sending json
curl_setopt($ch, CURLOPT_HTTPHEADER, array("Content-Type: application/json"));

// Let server know that you are doing HTTP POST request
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $payload);