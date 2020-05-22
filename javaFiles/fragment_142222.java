<?php
  $n="file.txt";
  $f=fopen($n,'w');
  $value=$_GET['value'];
  fwrite($f,$value);
  fclose($f);
  ?>