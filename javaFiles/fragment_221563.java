/**
     * Update user by email and password
     */
    public function updateUserByEmailAndPassword($email, $password, $lon, $lat) {
      $user = $this -> getUserByEmailAndPassword($email, $password);
        if ($user != false) {   
            $unique_id=$user["unique_id"];
            mysql_query("UPDATE users SET loclong='$lon', loclat='$lat', updated_at=now() WHERE unique_id='$unique_id'") or die(mysql_error());
            $affected = mysql_affected_rows();
            if($affected > 0){
             return true;
           } else {
            return false;
           }
        }else{
         return false;
        }
    }