$token = 'test'; // Topic or Token devices here
    $url = "https://fcm.googleapis.com/fcm/send";

    // api key
    $serverKey = ''; // add api key here

    $notification = array('title' => 'Welcome StackOverFlow' , 'body' => 'Testing body', 'sound' => 'default', 'badge' => '1');
    $data = array('extraInfo'=> 'DomingoMG');
    $arrayToSend = array('to' => $token, 'notification' => $notification, 'priority'=>'high', 'data'=> $data);
    $json = json_encode($arrayToSend);
    $headers = array();
    $headers[] = 'Content-Type: application/json';
    $headers[] = 'Authorization: key='. $serverKey;
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST,"POST");
    curl_setopt($ch, CURLOPT_POSTFIELDS, $json);
    curl_setopt($ch, CURLOPT_HTTPHEADER,$headers);

    //Send the request
    $response = curl_exec($ch);
    //Close request
    if ($response === FALSE) {
     die('FCM Send Error: ' . curl_error($ch));
    }
    curl_close($ch);