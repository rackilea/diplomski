foreach (Object obj in List<Object>) {
    setupVertexAttributes(obj.attributes);   //setup the attributes (VBOs)
    uploadMatrix(obj.matrix);                //set the matrix
    glDrawElements(obj.indices);             //draw the object

}