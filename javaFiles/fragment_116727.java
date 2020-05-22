<?php
    if( $_SERVER['REQUEST_METHOD']=='POST' ){

        /* clean/empty any output buffers without sending data */
        @ob_clean();

        /* send some data to your async request */
        echo json_encode( array( 'data'=>1, 'time'=>time() ), JSON_FORCE_OBJECT  );

        exit(); 
    }
?>