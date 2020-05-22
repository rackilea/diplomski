glDisable      (GL_DEPTH_TEST);

glStencilFunc  (GL_EQUAL, 1,       1      );
glStencilOp    (GL_KEEP,  GL_KEEP, GL_KEEP);

// Draw your model again, but with some special visual characteristic of your choosing.

glDisable      (GL_STENCIL_TEST);