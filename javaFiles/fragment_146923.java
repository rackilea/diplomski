<?php

/*
 * Following code will get single User's details
 * using the Student ID number
 */

// array for JSON response
$response = array();

// check for post data
if (isset($_POST['param1']) && 
    isset($_POST['param2']) && 
    isset($_POST['param3'])) {

    $param1 = $_POST['param1'];
    $param2 = $_POST['param2'];
    $param3 = $_POST['param3'];

    // include db connect class
    require_once __DIR__ . '/db_config.php';
    // set vars
    $host = DB_SERVER;
    $db   = DB_DATABASE;
    $user = DB_USER;
    $pass = DB_PASSWORD;
    $charset = 'utf8';

    $dsn = "mysql:host=$host;dbname=$db;charset=$charset";
    $opt = [
        PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        PDO::ATTR_EMULATE_PREPARES   => false,
    ];

    // connecting to db
    $pdo = new PDO($dsn, $user, $pass, $opt);

    $sql = 'SELECT * FROM tblYourTable 
            WHERE ID = :id_STM
            AND col2 >= :col2_STM
            AND col3 >= :col3_STM
            ';
    $stmt = $pdo->prepare($sql);
    $stmt->bindParam(':id_STM', $param1, PDO::PARAM_INT);
    $stmt->bindParam(':col2_STM', $param2, PDO::PARAM_STR); // this could be a string parameter
    $stmt->bindParam(':col3_STM', $param3, PDO::PARAM_STR); // oddly, Doubles are given as STR also!!

    $res = $stmt->execute();

    /* Check the number of rows that match the SELECT statement */
    if ($res) {
        // success
        $response["success"] = 1;
        // connection node
        $response["data"] = array();

        // This will retreive as many rows as your query has aquired
        while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
            $data = array(); // Your return array
            $data["data1"] = $row["Col1"];
            $data["data2"] = $row["Col2"];
            $data["data3"] = $row["Col3"];
            // ... and so on til you have all the data you need
            $data["data_N"] = $row["Col_N"];

            // pushes a new row onto your array with each iteration
            array_push($response["data"], $data);
        }
    }
    else {
        /* No rows matched -- do something else */
        // required field is missing
        $response["success"] = 0;
        $response["message"] = "No data returned!!";

    }   
}
else {
    $response["success"] = 0;
    $response["message"] = "Parameters are not correct";
}
// echoing JSON response
echo json_encode($response);
?>