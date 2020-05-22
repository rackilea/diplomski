<?php


$db = mysqli_connect("host", "userLogin", "userPwd", "dbName");

$id = 999;
$idc = 1;
$idd = 0;
$p = "gpog@email.com";
$la = 15478.12;
$l = 0;

$sql="
        INSERT INTO `table`
        (
            `field1`,
            `field2`,
            `field3`,
            `field4`,
            `field5`,
            `field6`
        )
        VALUES (
            $id,
            $idc,
            $idd,
            '".$p."',
            $la,
            $l
        )
    ;";
mysqli_query($db, $sql);

var_dump(mysqli_error($db));