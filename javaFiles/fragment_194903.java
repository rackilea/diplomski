<?php
    $host='127.0.0.1';
    $uname='root';
    $pwd='password';
    $db="android";

    $con = mysql_connect($host,$uname,$pwd) or die("connection failed");
    mysql_select_db($db,$con) or die("db selection failed");

    $wmail=$_REQUEST['email'];
    $password=$_REQUEST['password'];

    $flag['code']=0;

    if($r=mysql_query("insert into sample values('$email','$password') ",$con))
    {
        $flag['code']=1;
        echo"hi";
    }

    print(json_encode($flag));
    mysql_close($con);
?>