$times = time(); 
     $con = mysql_connect("localhost","username","password");
                if (!$con)
                {
                die('Could not connect: ' . mysql_error());
                 } 
                mysql_select_db("dbname", $con);


                $qry = mysql_query("UPDATE
                                     $tbalename SET      
                                    `areloggedin`= '$times'
                WHERE id = $variable_seession_foruser ");


                $result = @mysql_query($qry);