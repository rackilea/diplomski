glClearDepthf(0.0f);
glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
glDisable(GL_DEPTH_TEST);
// draw clip entity
glEnable(GL_DEPTH_TEST);
// draw children