<?php
    $desc = array(array('pipe','r'),array('pipe','w'));
    $resource= proc_open('bash',$desc,$pipes);
    if (!is_resource($resource))
    {
        throw new Exception('PDF stream creation failed');
    }
    usleep(5);//for safety
    fwrite($pipes[0],'java mkPDF paras'."\n");//double quoted \n is crucial
    fclose($pipes[0]);
    usleep(100);//while java app is running;
    $pdf = stream_get_contents($pipes[1]);
    fclose($pipes[1]);
    proc_close($resource);
?>