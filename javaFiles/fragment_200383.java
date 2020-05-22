<?php    
  $ch = curl_init();

  $data = array('name' => $_POST['name'], 'age' => $_POST['age']);

  curl_setopt($ch, CURLOPT_URL, 'YOUR_JAVA_WEB_URL');
  curl_setopt($ch, CURLOPT_POST, 1);
  curl_setopt($ch, CURLOPT_POSTFIELDS, $data);

  curl_exec($ch);
?>