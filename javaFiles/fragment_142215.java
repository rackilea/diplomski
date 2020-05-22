$output = array();

exec('java -version 2>&1', $output);
print_r($output); // contains the correct output

exec('java -jar myfile.jar', $output);
print_r($output); // should also contain the correct output