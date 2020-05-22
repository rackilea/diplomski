if (!isset($_POST('id')) die("Submission failed!");

$id = $_POST('id');

$mysqli = new mysqli(HOST, USER, PW, DB);   //assuming you have these static variables, change it for your settings

//use $id now to create the query
$query = "[...]";

$result = $mysqli->query($query);

echo json_encode($result);