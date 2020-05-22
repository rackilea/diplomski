function unicodeStrCmp($s1,$s2)
{
// designed to be same as java's String.compareTo
// not extensivley tested, and doesn't deal with surrogate pairs
$l1 = mb_strlen($s1);
$l2 = mb_strlen($s2);
$i = 0;
while ($i<$l1 && $i<$l2)
{
    $c1 = mb_convert_encoding(mb_substr($s1,$i,1),'utf-16le');
    $c1 = ord($c1[0])+(ord($c1[1])<<8);
    $c2 = mb_convert_encoding(mb_substr($s2,$i,1),'utf-16le');
    $c2 = ord($c2[0])+(ord($c2[1])<<8);
    $res = $c1-$c2;
    if ($res!=0)
        return $res;
    $i++;
}
return $l1-$l2;
}