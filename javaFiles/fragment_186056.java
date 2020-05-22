<?php

$username = @$_GET['username'];
if(empty($username))
{
    http_response_code(400);
    die;
}

echo exec("java -jar C:\UUID.jar $username");
?>