<?php

class AddInformation
{

   function response(){
      /** @var mysqli $con */
      require_once('dbConnect.php'); //$con = new mysqli('127.0.0.1', 'root', '', 'so');
      $status = $con->real_escape_string($_POST['status']);
      $timein = $con->real_escape_string($_POST['timein']);

      $con->query("INSERT INTO information (status, time_in) VALUES ('$status', '$timein')");
      echo $con->insert_id;
   }
}

$ai = new AddInformation();
$ai->response();