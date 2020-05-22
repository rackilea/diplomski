<?php
$con = mysqli_connect("mysql11.000webhost.com", "(number for 000webhost.com)_user", "(password)", "(number for 000webhost.com)_data");

$first_name = $_POST["first_name"];
$last_name = $_POST["last_name"];
$email = $_POST["email"];
$password = $_POST["password"];


    $myfile = fopen("checkdata.log", "w") or die("Unable to open file!");
    fwrite($myfile, "\nfirst name= ".$first_name." last name= ".$last_name." email= ".$email." password=".$password." \n");       
    fclose($myfile);

    $statement = mysqli_prepare($con, "INSERT INTO user (first_name, last_name, email, password) VALUES (?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssss", $first_name, $last_name, $email, $password);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;  

    echo json_encode($response);
?>