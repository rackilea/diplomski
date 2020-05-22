fun render(camera: OrthographicCamera) {
    val parentRotation = (me().physicsRoot.rotationR() * MathUtils.radDeg) 
    val parentTransform = me().physicsRoot.transform
    val myPosition = vec2(offsetX, offsetY)
    parentTransform.mul(myPosition)
    poly.color = color.get()
    poly.setOrigin(0f, 0f)
    poly.setPosition(myPosition.x, myPosition.y)
    poly.rotation = parentRotation + rotationD
    poly.setScale(scaleX, scaleY)
    poly.draw(JJ.B.renderWorld.polyBatch)
    recycle(myPosition)
}