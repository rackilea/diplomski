if ($score > $roll) # chosen a word
{
    $sentence .= "$nw " unless $nw eq ".";
    $cw = $nw;
    last;
}