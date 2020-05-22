<?php
$response = array();

if(isset($_POST['stars'], $_POST['username'])){

    $stars= $_POST['stars'];
    $username = $_POST['username'];

    $connect = mysql_connect("*****", "****", "*****") or die("Can't connect to database!");
    mysql_select_db("a9698368_webserv") or die("Can't select database!");

    try{
        $query = sprintf("UPDATE users SET easy_level1 ='%s' WHERE username ='%s'",
                                     mysql_real_escape_string($stars),
                                     mysql_real_escape_string($username));
        mysql_query($query);
    }
    catch (Exception $ex) {
        $response["success"] = 0;
        $response["message"] = "Database Error. Please Try Again!";
    }


    if ( mysql_affected_rows() > 0) {
        $response["success"] = 1;
        $response["message"] = "Updated successful!";
    } else {
        $response["success"] = 0;
        $response["message"] = "Can't update the stars!";
    }
    mysql_close();

}
else{
    $response["success"] = 0;
    $response["message"] = "Missing post data!";
}
echo json_encode($response);
?>