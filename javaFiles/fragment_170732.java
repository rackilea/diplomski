GLES20.glDisableVertexAttribArray(a_model);
GLES20.glDisableVertexAttribArray(a_model + 1);
GLES20.glDisableVertexAttribArray(a_model + 2);
GLES20.glDisableVertexAttribArray(a_model + 3);
GLES20.glVertexAttrib4fv(a_model, matrix, matrixIndex * 16);
GLES20.glVertexAttrib4fv(a_model + 1, matrix, (matrixIndex * 16) + 4);
GLES20.glVertexAttrib4fv(a_model + 2, matrix, (matrixIndex * 16) + 8);
GLES20.glVertexAttrib4fv(a_model + 3, matrix, (matrixIndex * 16) + 12);