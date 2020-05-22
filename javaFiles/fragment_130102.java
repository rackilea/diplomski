if (isset($_POST['base64'])) {
$data = $_POST['base64'];
$data = base64_decode($data);

$status = file_put_contents("profiles/$uuid.png", $data);

if ($status == false) {
    echo(json_encode(array(
        "response" => "Failed to change profile picture.",
        "responseCode" => "0"
    )));
} else {
    echo(json_encode(array(
        "response" => "Successfully changed your profile picture!",
        "responseCode" => "1"
    )));
}