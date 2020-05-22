ctor() {
    textureSolid = makeTextureBox(1, 0xFFFF0000, 0, 0); 
    float a = 100;
    float b = 100;
    PolygonRegion polyReg = new PolygonRegion(new TextureRegion(textureSolid),
      new float[] {
        a*0, b*0,
        a*0, b*2,
        a*3, b*2,
        a*3, b*0,
        a*2, b*0,
        a*2, b*1,
        a*1, b*1,
        a*1, b*0,
    });
    poly = new PolygonSprite(polyReg);
    poly.setOrigin(a, b);
    polyBatch = new PolygonSpriteBatch();
}