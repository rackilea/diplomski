if (mysqli_num_rows($res)>0) {
   $dbPassword = $row['Password'];

   if (PASSWORD_VERIFY($Password, $dbPassword)) {
     $id = $row['id'];
     $_SESSION['id'] = $id;
     exit();

   } else {
   //...