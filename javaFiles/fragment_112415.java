<?php

$process_cmd = "java -jar test.jar";

$env = NULL;
$options = ['bypass_shell' => true];
$cwd = NULL;
$descriptorspec = [
    0 => ["pipe", "r"], // stdin is a pipe that the child will read from
    1 => ["pipe", "w"], // stdout is a pipe that the child will write to
    2 => ["pipe", "w"]  // stderr is a file to write to
];

$process = proc_open($process_cmd, $descriptorspec, $pipes, $cwd, $env, $options);

if (is_resource($process)) {

    //feeding text to java
    fwrite($pipes[0], "Test text");
    fclose($pipes[0]);

    //echoing returned text from java
    echo stream_get_contents($pipes[1]);
    fclose($pipes[1]);

    //It is important that you close any pipes before calling
    //proc_close in order to avoid a deadlock
    $return_value = proc_close($process);

    echo "\n command returned $return_value\n";
}

?>