// reading color
glReadBuffer( GL_COLOR_ATTACHMENT0_EXT );
glReadPixels( 0, 0, WIDTH, HEIGHT, GL_RGBA, GL_UNSIGNED_BYTE, color );

// reading depth
glReadBuffer( GL_DEPTH_ATTACHMENT_EXT );
glReadPixels( 0, 0, WIDTH, HEIGHT, GL_DEPTH_COMPONENT, GL_FLOAT, depth );