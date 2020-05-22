//First object
glTranslatef/glScalef/... for object1
glBindBuffer(buffer1)

gl.glVertexPointer(...) and all the other pointers/glEnableClientStates

gl.glDrawArrays(vertNo);

//Now second object

glTranslatef/glScalef/... for object2
glBindBuffer(buffer2)

gl.glVertexPointer(...) and all the other pointers/glEnableClientStates

gl.glDrawArrays(vertNo1);