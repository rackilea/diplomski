<?php
/**
 * Auxiliary function: prints the main node from the returned value
 */
function print_xml_node( $string )
{
    $xml = simplexml_load_string( $string );
    printf( '<pre><code>%s</code></pre>', print_r( $xml->params->param->value->array->data->value, true ) );
}

/**
 * XML-RPC call
 */
function query_last_posts( $methodName, $url, $parameters )
{
    $request = xmlrpc_encode_request( $methodName, $parameters );
    $ch = curl_init();
    curl_setopt( $ch, CURLOPT_POSTFIELDS, $request );
    curl_setopt( $ch, CURLOPT_URL, $url );
    curl_setopt( $ch, CURLOPT_RETURNTRANSFER, 1 );
    curl_setopt( $ch, CURLOPT_TIMEOUT, 1 );
    $results = curl_exec( $ch );
    curl_close( $ch );
    return $results;
}

$blog_id = 1;
$user = 'username';
$pass = 'password';
$type = 'post';
$category = 1; // ID or category name
$num_posts = 1;
$args = array( $blog_id, $user, $pass, $type, $category, $num_posts, null );
$response = query_last_posts( 'b5f.getPosts', 'http://EXAMPLE.COM/xmlrpc.php', $args );

print_xml_node( $response );