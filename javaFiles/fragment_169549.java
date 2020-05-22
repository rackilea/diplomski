<?php
try {
    $conn = new PDO('mysql:host=localhost;dbname=beanbag', **********, ********);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch(PDOException $e) {
    echo 'ERROR: ' . $e->getMessage();
}

$sql = $conn->query("select * from Recipes");
while (($row = $sql->fetch(PDO::FETCH_ASSOC)) !== false)
    $output[]=$row;
print(json_encode($output));
?>