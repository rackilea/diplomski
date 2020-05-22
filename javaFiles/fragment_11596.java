glClearStencil (0x00);
glClear        (GL_STENCIL_BUFFER_BIT);

glEnable       (GL_DEPTH_TEST);
glEnable       (GL_STENCIL_TEST);

glStencilFunc  (GL_ALWAYS, 1,          1      );
glStencilOp    (GL_KEEP,   GL_REPLACE, GL_KEEP);

// Draw your model as usual