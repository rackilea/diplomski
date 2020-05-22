//Executing query to database
if(mysqli_query($con,$sql)){
    // echo 'Information Added Successfully'; // Remove this line
    $insertId= mysqli_insert_id($con);
    $response["lastId"]=$insertId;
    echo json_encode($response);
}else{
    echo 'Could Not Add Information';
}