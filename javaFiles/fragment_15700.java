if( isset( $_FILES['img-content'] ) ) {
    $img = str_replace( " ","_",$_FILES['img-content']['name'] );
    move_uploaded_file( $_FILES['img-content']['tmp_name'], "../../images/content/".$img );
    $source = "../../images/content/";
    $dest = "../../images/thumb/";
    thumbnail( $img, $source, $dest, 480, 400 );