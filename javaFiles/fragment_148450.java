public class Mesh {

    // [...]

    public void draw(){

        glBindVertexArray(this.vao);
        glDrawArrays(GL_TRIANGLES, 0, this.size);
        glBindVertexArray(0); // <--- Note, this is not needed
    }
}