public class FrameBufferObject {

private int width;
private int height;

private int frameBufferID;
private int texture;
private int depthTexture;
private int depthBuffer;

private Matrices.MatrixKit previousMatrixKit;

public FrameBufferObject(int width, int height) {
    this.width = width;
    this.height = height;

    initFrameBuffer();
}

private void initFrameBuffer() {

    frameBufferID = createFrameBuffer();
    texture = createTextureAttachment();
    depthTexture = createDepthTextureAttachment(width, height);
    depthBuffer = createDepthBufferAttachment();

    int status = glCheckFramebufferStatus(GL_FRAMEBUFFER);
    if (status != GL_FRAMEBUFFER_COMPLETE) {
        Logger.error("Framebuffer not Complete! STATUS: " + status + "\nWidth: " + width + "\nHeight: " + height);
    }

    glBindFramebuffer(GL_FRAMEBUFFER, 0);
}

private int createFrameBuffer() {
    int[] ids = new int[1];
    glGenFramebuffers(1, ids, 0);
    int frameBufferID = ids[0];
    glBindFramebuffer(GL_FRAMEBUFFER, frameBufferID);

    int[] buffers = new int[] {GL_COLOR_ATTACHMENT0};

    GLES30.glDrawBuffers(1, buffers, 0);
    return frameBufferID;
}

private int createTextureAttachment() {
    int[] ids = new int[1];
    glGenTextures(1, ids, 0);
    int colorTexture = ids[0];

    glBindTexture(GL_TEXTURE_2D, colorTexture);
    glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, null);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
    glFramebufferTexture2D(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_TEXTURE_2D, colorTexture, 0);
    return colorTexture;
}

private int createDepthTextureAttachment(int width, int height) {
    int[] ids = new int[1];
    glGenTextures(1, ids, 0);
    int depthTextureID = ids[0];

    glBindTexture(GL_TEXTURE_2D, depthTextureID);
    //glTexImage2D(GL_TEXTURE_2D, 0, GL_DEPTH_COMPONENT16, width, height, 0, GL_DEPTH_COMPONENT, GL_FLOAT, null);
    glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_DEPTH_COMPONENT, GL_FLOAT, null);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
    glFramebufferTexture2D(GL_FRAMEBUFFER, GL_DEPTH_ATTACHMENT, GL_TEXTURE_2D, depthTextureID, 0);
    return depthTextureID;
}

private int createDepthBufferAttachment() {
    int[] ids = new int[1];
    glGenBuffers(1, ids, 0);
    int depthBuffer = ids[0];

    glBindRenderbuffer(GL_RENDERBUFFER, depthBuffer);
    glRenderbufferStorage(GL_RENDERBUFFER, GL_DEPTH_COMPONENT16, width, height);
    glFramebufferRenderbuffer(GL_FRAMEBUFFER, GL_DEPTH_ATTACHMENT, GL_RENDERBUFFER, depthBuffer);
    return depthBuffer;
}

public int getColorTexture() {
    return this.texture;
}

public void bindFrameBuffer() {
    glBindTexture(GL_TEXTURE_2D, 0); //just make sure the texture isn't bound
    glBindFramebuffer(GL_FRAMEBUFFER, frameBufferID);
    glViewport(0, 0, width, height);

    previousMatrixKit = Renderer.getMatrices();
    Renderer.setMatrixKit(Matrices.createMatrixKit(width, height));
}

public void unbindFrameBuffer() {
    glBindFramebuffer(GL_FRAMEBUFFER, 0);
    glViewport(0, 0, previousMatrixKit.width, previousMatrixKit.height);

    Renderer.setMatrixKit(previousMatrixKit);
}

public int getWidth() {
    return this.width;
}

public int getHeight() {
    return this.height;
}

public int getID() {
    return this.frameBufferID;
}
}