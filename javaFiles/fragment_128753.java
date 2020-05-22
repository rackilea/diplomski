<?php 
    $username = $_GET['u']; 
    $password = $_GET['p']; 

    if ($username=='Username_String' && $password=='Password_String') { 
        echo 'true'; 
    } else { 
        echo 'username = ' . $username . ' Password = ' . $password; 
    } 
?>