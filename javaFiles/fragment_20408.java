//modify the elements of the vertex array as desired to move the lines around.

mesh.setVertices(vertices);
shaderProgram.begin();
shaderProgram.setUniformMatrix("u_projModelView", camera.combined);
mesh.render(shaderProgram, GL20.GL_LINES);
shaderProgram.end();