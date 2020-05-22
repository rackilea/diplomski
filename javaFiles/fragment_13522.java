hexString.append( Integer.toHexString(0xFF & message[ i ] ) );
function makeBrokenMD5($s) {
$hash= md5($s, TRUE);
$bytes= preg_split('//', $hash, -1, PREG_SPLIT_NO_EMPTY);
$broken= '';
foreach ($bytes as $byte)
    $broken.= dechex(ord($byte));
return $broken;