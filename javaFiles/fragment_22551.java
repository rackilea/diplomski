$postpassword = 'YAGG7GcpUxIZzBnHuaezPf5BWFhFalBPgvue/0wFoRLu+JsKslG8wPCv6dPubIBk1aFIJ8spK8S17347aDBAYA==';
$postsalt = 'ww0g+f77ygKD7Iww1GTYtg==';
$dbpassword = 'sQnzu7wkTrgkQZF+0G1hi5AI3Qmzvv0bXgc5THBqi7mAsdd4Xll27ASbRt9fEyavWi6m0QP9B8lThf+rDKy8hg==';

if($postpassword == base64_encode(hash('sha512', $postsalt.$dbpassword, true))) {
    echo 'OK';
}