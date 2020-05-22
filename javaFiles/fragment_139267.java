$submittedCode = $_REQUEST["code"]; //
$myfile = fopen("newfile.java", "w") or die("Unable to open file!");
fwrite($myfile, $submittedCode);
$res = exec("/usr/local/bin/javac " . $myfile);
if (strlen($res) == 0) {
  //it compiled successfully. load the compiled class file and echo it out. Make sure to set content type header
} else {
  echo $res;
}