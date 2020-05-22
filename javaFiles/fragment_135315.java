// array for JSON response
$response = array();
$response["apps"] = array();

$apps = array();

$apps["name"] = $row["name"];
$apps["package"] = $row["package"];
$apps["version"] = $row["version"];
$apps["dateversion"] = $row["dateversion"];

array_push($response["apps"], $apps);

$response["success"] = 1;

echo json_encode($response);