<?php
$directory = 'Set here the directory you want the file to be uploaded to';
$filename = basename($_FILES['file']['name']);
if(strrchr($_FILES['file']['name'], '.')=='.png') {//Check if the actual file extension is PNG, otherwise this could lead to a big security breach
    if(move_uploaded_file($_FILES['file']['tmp_name'], $directory. $filename)) { //The file is transfered from its temp directory to the directory we want, and the function returns TRUE if successfull
        //Do what you want, SQL insert, logs, etc
    }
}
?>