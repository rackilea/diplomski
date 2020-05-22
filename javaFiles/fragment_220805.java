public void draw(SpriteBatch g, Texture scr) {
    updateshaders();
    //Distortion
    coords = gs.cam.project(new Vector3(x,y,0));

    if(scr != null){
        g.setShader(waterShader2);
        g.begin();
        g.draw(scr,
            x,y,
            width,height- gs.gsm.rm.water_top.getRegionHeight() / 4);
        g.end();
    }
    //SURFACE WAVES
    g.setShader(waterShader);
    g.begin();
    g.draw(gs.gsm.rm.water_top, x, y + height - gs.gsm.rm.water_top.getRegionHeight(), width, gs.gsm.rm.water_top.getRegionHeight());
    g.end();
    //BACK TO NORMAL
    g.setShader(null);
    g.begin();
    g.draw(gs.gsm.rm.water, x, y, width, height - gs.gsm.rm.water_top.getRegionHeight());
}