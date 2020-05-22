function string_converter($s1){
    $ac = array('W', 'A', '1', '2', '3', '4', '4', '4', 'Q', 'C');
    for ($i = 0; $i < 10; $i++) { 
        $ac[$i] = $ac[$i] - ($i + 1); 
    }
    $s2 = implode("",$ac);
    return strtoupper(md5(md5($s2.$s1)));
}