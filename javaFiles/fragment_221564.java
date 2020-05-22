else if ($tag == 'update_location') { // check for tag type
        // Request type is check Login
        $email = $_POST['email'];
        $password = $_POST['password'];

        // Request lon/lat
        $lon = $_POST['lon'];
        $lat = $_POST['lat'];

        // check for user
        $state = $db->UpdateUserByEmailAndPassword($email, $password, $lon, $lat);
        if ($state != false) {
            $response["success"] = 1;
            $response["success_msg"] = "Geo location data update successfull!";
            echo json_encode($response);
        } else {
            // user not found
            // echo json with error = 1
            $response["error"] = 1;
            $response["error_msg"] = "Geo location data update failed!";
            echo json_encode($response);
        }
    }