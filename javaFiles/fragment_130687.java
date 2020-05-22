exec('java /path/to/Main '.escapeshellarg($phonecode). ' '.escapeshellarg($keyword).' '.escapeshellarg($location), $output, $status);
if ($status === 0)
{//always check exit code, 0 indicates success
    var_dump($output);
}
else
    exit('Error: java exec failed: '.$status);