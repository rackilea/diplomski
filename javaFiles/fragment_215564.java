<?php

$con = mysqli_connect("127.0.0.1" , "(not real username)" , "(not real                                                          password - this part works 100% sure)" , "android_api");

//Check connection
if (mysqli_connect_errno()) echo "Failed to connect to MySQL: " . mysqli_connect_error();

$partyName = $_POST["partyName"];
$hostName = $_POST["hostName"];
$latitude = $_POST["latitude"];
$longitude = $_POST["longitude"];

function registerUser(){
  global $con, $partyName, $hostName, $latitude, $longitude;
  $statement = mysqli_prepare($con, "INSERT INTO parties (partyName,        hostName, latitude, longitude) VALUES (?, ?, ?, ?)");
mysqli_stmt_bind_param($statement, "ssss", $partyName, $hostName, $latitude, $longitude);
mysqli_stmt_execute($statement);
mysqli_stmt_close($statement);
 }
registerUser();
$response = array();
$response["success"] = true;

echo json_encode($response);
?>﻿