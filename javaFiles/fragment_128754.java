<?php 
    $username = $_REQUEST['u']; // or $_POST 
    $password = $_REQUEST['p']; 

    if ($username=='Username_String' && $password=='Password_String') { 
        echo 'true'; 
    } else { 
        echo 'username = ' . $username . ' Password = ' . $password; 
    } 
?>