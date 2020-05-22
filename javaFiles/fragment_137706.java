require ("../config.inc.php");

$query = "SELECT * FROM remarks WHERE patient_id = :patient_id";
$query_params = array(':patient_id' => $_GET["patient_id"]);

try{
    $stmt = $dbname->prepare($query);
    $result = $stmt->execute($query_params);    

    $query = "SELECT * FROM remarks WHERE remarks_id = :remarks_id";
    $query_params = array(':remarks_id' => $_GET["remarks_id"]);

    $q = $dbname->prepare($query); 
    $r = $q->execute($query_params);


}catch(PDOException $ex){
        $response["success"] = 0;
        $response["message"] = $ex;

        die(json_encode($response));
}

$rows = $stmt->fetchAll();

if($rows){
    $response["post"] = array();
    foreach($rows as $row){

        $post               = array();
        $post["date"]       = $row["date"];
        $post["diagnosis"]  = $row["diagnosis"];
        $post["medication"] = $row["medication"];
        $post["description"]= $row["description"];

        array_push($response["post"], $post);
        }

    echo json_encode($response);
}
else{
    $response["status"] = "FAIL";
    $response["success"] = 0;
    $response["message"] = "No available patient's record";

    die(json_encode($response));

}