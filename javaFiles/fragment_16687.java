<?php
/**
 * Plugin Name: (SO) Custom XML-RPC
 * Author: brasofilo
 * Plugin URI: http://stackoverflow.com/a/25507463/1287812
 */

add_filter( 'xmlrpc_methods', 'add_my_xmlrpc_methods' );

function add_my_xmlrpc_methods( $methods ) {
    $methods['b5f.getPosts'] = 'b5f_xmlrpc_get_posts';
    return $methods;
}

function b5f_xmlrpc_get_posts( $args ) {
    global $wp_xmlrpc_server;
    $wp_xmlrpc_server->escape( $args );

    $blog_ID     = (int) $args[0];
    $username  = $args[1];
    $password   = $args[2];
    $post_type  = $args[3];
    $category = $args[4];
    $numberposts = $args[5];
    $extra = $args[6];

    if ( !$user = $wp_xmlrpc_server->login($username, $password) ) {
        return $wp_xmlrpc_server->error;
    }

    $category_int = (int) $category;

    if( !empty( $category_int ) ) {
        $category_call = 'cat';
    } else {
        $category_call = 'category_name';
    }

    $post_args = array(
        'numberposts' => $numberposts,
        'posts_per_page' => $numberposts,
        $category_call => $category,
        'post_type' => $post_type,
        'post_status' => 'any'
    );
    if( is_array( $extra ) )
        $post_args = array_merge( $post_args, $extra );

    $posts_list = get_posts( $post_args );

    if ( !$posts_list ) {
        $wp_xmlrpc_server->error = new IXR_Error(500, __('Either there are no posts, or something went wrong.'));
        return $wp_xmlrpc_server->error;
    } else {
        return $posts_list;
    }
}