<?php
$link = mysqli_connect('localhost', 'mysql_user', 'mysql_password');
if (!$link) {
    die('Could not connect: ' . mysqli::$connect_error() );
}
mysqli::select_db('mydb');

mysqli::query("INSERT INTO mytable (product) values ('kossu')");
printf("Last inserted record has id %d\n", mysqli::$insert_id());
?>