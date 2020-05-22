<?php
  if(isset($_POST["onlineStatus"])) {
    if($_POST["onlineStatus"] == "iAmStillHere") {
      $fd = fopen("log.txt", "w");
      fwrite($fd, date("[d.m.Y - H:i:s] ").$_SERVER['REMOTE_ADDR'].": He is still here"); //Puts out something like "[26.03.2014 - 13:57:33] 127.0.0.1: He is still here"
      fclose($fd);
    }
  }