fun polygonSprite(points: Array<Vector2>): PolygonSprite {
        val pix = Pixmap(1, 1, Pixmap.Format.RGBA8888)
        pix.setColor(0xFFFFFFFF.toInt())
        pix.fill()
        val textureSolid = Texture(pix)
        val vertices = FloatArray(points.size * 2)
        val triangleIndices = triangulator.computeTriangles(vertices)
        for (i in 0..points.size - 1) {
            val point = points.get(i)
            val offset = i * 2
            vertices[offset] = point.x
            vertices[offset + 1] = point.y
        }
        val polyReg = PolygonRegion(TextureRegion(textureSolid),
                vertices, triangleIndices.toArray())
        val poly = PolygonSprite(polyReg)
        return poly
    }