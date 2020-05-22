$options = array(
    'http' => array(
        'method' => "POST",
        'header' => "Accept-language: en\r\n" . "Content-type: application/x-www-form-urlencoded\r\n",
        'content' => http_build_query(array(
            'studentnumber' => $studentnumber,
            'studentdata' => $encryptedData,
        ),'','&'
    )
));

$refno = file_get_contents($requestUrl,false,$context);