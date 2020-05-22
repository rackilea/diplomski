$descriptorspec = array(
       0 => array("file", "tmp/stdin.log", "a"),
       1 => array("file", "tmp/stdout.log", "a"),
       2 => array("file", "tmp/stderr.log", "a")
    );

    $process = proc_open ('START /B start_selenium_server.bat', $descriptorspec, $pipes);

   if (is_resource($process)) {

        $response = proc_close($process);


        if ($response == 0) {
            return redirect()->back()->with("message", "Kommando wurde ausgeführt.")
                                     ->with("status", "success");
        } else {
            return redirect()->back()->with("message", "Error !")
                                     ->with("status", "warning")
        }

    }