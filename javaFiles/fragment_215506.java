<?php

$indir = array_filter(scandir('event1'), function($item) {
        return $item[0] !== '.';
});

echo json_encode($indir);
?>