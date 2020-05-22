<?php

    function thumbnail( $img, $source, $dest, $maxw, $maxh ) {      
        $jpg = $source.$img;

        if( $jpg ) {
            list( $width, $height  ) = getimagesize( $jpg ); //$type will return the type of the image
            $source = imagecreatefromjpeg( $jpg );

            if( $maxw >= $width && $maxh >= $height ) {
                $ratio = 1;
            }elseif( $width > $height ) {
                $ratio = $maxw / $width;
            }else {
                $ratio = $maxh / $height;
            }

            $thumb_width = round( $width * $ratio ); //get the smaller value from cal # floor()
            $thumb_height = round( $height * $ratio );

            $thumb = imagecreatetruecolor( $thumb_width, $thumb_height );
            imagecopyresampled( $thumb, $source, 0, 0, 0, 0, $thumb_width, $thumb_height, $width, $height );

            $path = $dest.$img."_thumb.jpg";
            imagejpeg( $thumb, $path, 75 );
        }
        imagedestroy( $thumb );
        imagedestroy( $source );
    }

?>