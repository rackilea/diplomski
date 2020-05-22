create framebuffer
enable framebuffer
for all frames {
    render to framebuffer
    glGetTexImage(...)
    library.encodeFrame(imageData)
}