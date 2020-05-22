<?php
    include_once("Java.inc");

$i1 = new Java("your.class", "1");
$i2 = new Java("your.class", "2");
$i3 = $i1->add($i2);
echo $i3->toString() . "\n";
?>