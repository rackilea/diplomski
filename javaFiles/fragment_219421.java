$iv_size = mcrypt_get_iv_size(MCRYPT_RIJNDAEL_128, MCRYPT_MODE_ECB);
  $iv = mcrypt_create_iv($iv_size, MCRYPT_RAND);
  $key = "Put your secret key here";
  $text = "<xml>This is your XML text</xml>";

  //encrypting now with RIJNDAEL 128 encryption.
  $crypttext = mcrypt_encrypt(MCRYPT_RIJNDAEL_128, $key, $text, MCRYPT_MODE_ECB, $iv);

  //Display encrypted content
  echo $crypttext;