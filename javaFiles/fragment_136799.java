<?php

function groupByKey($input) {
    $result = array();

    foreach($input as $item) {
        foreach($item as $key => $value) {
            $result[$key][] = $value;
        }
    }

    return $result;
}

$data = array(
    array(1 => 22),
    array(1 => 33),
    array(2 => 44),
    array(2 => 55),
    array(3 => 66),
    array(1 => 77)
);

print_r($data);
echo "\n\n";

$result = groupByKey($data);

print_r($result);