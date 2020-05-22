function unsignedRightShift($a, $b) {
    if ($b >= 32 || $b < -32) {
        $m = (int)($b/32);
        $b = $b-($m*32);
    }

    if ($b < 0) {
        $b = 32 + $b;
    }

    if ($b == 0) {
        return (($a>>1)&0x7fffffff)*2+(($a>>$b)&1);
    }

    if ($a < 0) 
    { 
        $a = ($a >> 1); 
        $a &= 0x7fffffff; 
        $a |= 0x40000000; 
        $a = ($a >> ($b - 1)); 
    } else { 
        $a = ($a >> $b); 
    } 
    return $a; 
}