$stdout_stream = ssh2_exec($connection, "java -version");

$err_stream = ssh2_fetch_stream($stdout_stream, SSH2_STREAM_STDERR);

$dio_stream = ssh2_fetch_stream($stdout_stream, SSH2_STREAM_STDDIO);

stream_set_blocking($err_stream, true);
stream_set_blocking($dio_stream, true);

$result_err = stream_get_contents($err_stream));
$result_dio = stream_get_contents($dio_stream));