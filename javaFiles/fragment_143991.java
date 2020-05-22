<?php require_once 'connect.php';

 //json response array
 $response = array("error" => FALSE);

if (isset($_POST['id']) && isset($_POST['password'])){ 

//receiving the post params
$id = mysqli_real_escape_string($conn,$_POST['id']);
$password = mysqli_real_escape_string($conn,$_POST['password']);

//get the student
$student = getStudent($id, $password);
if ($student != false){

    //user is found
    $response["error"] = FALSE;
    $response["student"] ["id"] = $student["id"];
    $response["student"] ["email"] = $student["email"];


    echo json_encode($response);
}

else {
    //user is not found with credentials
    $response["error"] =TRUE;
    $response["error_msg"] = "Wrong Student or Password";

    echo json_encode($response);
    }
}
else {

    //required post params is missing
    $response["error"] = TRUE;
    $response["error_msg"] = "Required paramaters missing";

    echo json_encode($response);

}

function getStudent($id, $password)
{
    global $conn;
    $query = "SELECT * from students_table where username = '{$id}'";
    $student = mysqli_query($conn, $query);
    $rows   = mysqli_num_rows($student);
    $row    = mysqli_fetch_assoc($student);

    if ($rows > 0 || password_verify($password, $row['password'])) {
        return $row;

    }
    else {
        return false;
    }
}
?>