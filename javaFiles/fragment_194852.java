$stmt = $this->conn->prepare("SELECT salt, encrypted_password FROM users WHERE email = ?");

$stmt->bind_param("s", $email);

if ($stmt->execute()) {
    $stmt->bind_result($salt, $encrypted_password);
    if($stmt->fetch()) {
        // verifying user password
        $hash = $this->checkhashSSHA($salt, $password);
        // check for password equality
        if ($encrypted_password == $hash) {
            $user = array();
            $user["salt"] = $salt;
            $user["encrypted_password"] = $encrypted_password;
            // if you want to return all the columns from database
            // then add other lines here
            // like $user["name"] = $name;
            // and make sure you have declared $name in bind_result method
            return $user;
        }
    } else {
        return NULL;
    }
} else {
    return NULL;
}