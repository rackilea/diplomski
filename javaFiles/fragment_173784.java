val textureIDList = new Array[Int](1)
gl.glGenTextures(1, textureIDList, 0)
gl.glBindTexture(GL.GL_TEXTURE_2D, textureIDList(0))
gl.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR)
gl.glTexParameterf(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR)
val dataBuffer = image.getRaster.getDataBuffer   // image is a java.awt.image.BufferedImage (loaded from a PNG file)
val buffer: Buffer = dataBuffer match {
  case b: DataBufferByte => ByteBuffer.wrap(b.getData)
  case _ => null
}
gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, image.getWidth, image.getHeight, 0, GL.GL_RGBA, GL.GL_UNSIGNED_BYTE, buffer)

...

gl.glDeleteTextures(1, textureIDList, 0)