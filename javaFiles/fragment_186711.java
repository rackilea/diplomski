<?php
    $stringToConvert = "äöüß";
    $md5 = md5(utf8_encode($stringToConvert), true);
    for($i = 0; $i < strlen($md5); $i++) {
        $c = ord($md5[$i]);
        $b[] = $c > 127 ? $c-256 : $c;
    }
    print_r($b);
?>