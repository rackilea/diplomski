<?php
    $mysqli = new mysqli("Your host", "Db username", "Db password", "Db name");

    if ($mysqli->connect_errno) {
        echo "Couldn't connect to database";
    }

    $number = $mysqli->real_escape_string($_POST['number1']);
    $format= $mysqli->real_escape_string($_POST['format1']);
    $name= $mysqli->real_escape_string($_POST['name1']);
    $price= $mysqli->real_escape_string($_POST['price1']);

    $query = "INSERT INTO Table (number, format, name, price) VALUES('$number','$format','$name', '$price');";

    $result = $mysqli->query($query);

if($result)
{
        echo "Successfully inserted";
}

   ?>