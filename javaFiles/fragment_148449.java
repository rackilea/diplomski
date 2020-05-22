public class Mesh {

    private int vao;
    private int vbo;
    private int size;

    public Mesh() {
       this.size = 0;

       this.vao = glGenVertexArrays();
       this.vbo = glGenBuffers();

       glBindVertexArray(this.vao);

       glBindBuffer(GL_ARRAY_BUFFER, vbo);
       glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
       glEnableVertexAttribArray(0);
    }

    // [...]
}