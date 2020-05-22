foreach ($_REQUEST as $key => $val) {
    // make sure fruit is at the beginning of the string, but not false
    if (strpos($key, 'fruit')===0) { 
        processFruit($val);
    }
}