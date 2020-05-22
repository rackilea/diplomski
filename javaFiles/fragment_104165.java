<?php

// Flag definitions
$defs = array(
    "opt1" => 1,
    "opt2" => 2,
    "opt3" => 4,
    "opt4" => 8,
    "opt5" => 16,
    "opt6" => 32
);

// enable flag 1,3 and 4 by using a bitwise "OR" Operator
$test = $defs["opt1"] | $defs["opt3"] | $defs["opt4"];
displayFlags($test, $defs);

// enable flag 6, too
$test |= $defs["opt6"];
displayFlags($test, $defs);

// disable flag 3
$test &= ~$defs["opt3"];
displayFlags($test, $defs);

// little improvement: the enableFlag/disableFlag functions
enableFlag($test, $defs["opt5"]);
displayFlags($test, $defs);

disableFlag($test, $defs["opt5"]);
displayFlags($test, $defs);

function displayFlags($storage, $defs) {   

    echo "The current storage value is: ".$storage;
    echo "<br />";

    foreach($defs as $k => $v) {
        $isset = (($storage & $v) === $v);
        echo "Flag \"$k\" : ". (($isset)?"Yes":"No");
        echo "<br />";
    }

    echo "<br />";
}

function enableFlag(&$storage, $def) {
    $storage |= $def;
}

function disableFlag(&$storage, $def) {
    $storage &= ~$def;
}