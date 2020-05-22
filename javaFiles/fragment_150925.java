...

int texAttrib = glGetAttribLocation(program, "texcoord");
glVertexAttribPointer(texAttrib, 2, GL_FLOAT, false, 7 * SIZE_OF_FLOAT, 5 * SIZE_OF_FLOAT);
glEnableVertexAttribArray(texAttrib);

int texUnit = 0;
int texUniform = glGetUniformLocation( program, "tex" );
glUniform1i( texUniform, texUnit );
glActiveTexture( GL_TEXTURE0 + texUnit );
glBindTexture( GL_TEXTURE_2D, tex );

...