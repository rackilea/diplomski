File f = new File("cbc.db");
if(f.exists() && !f.isDirectory()) { 
    int h = v.getHeight();
    ShapeDrawable mDrawable = new ShapeDrawable(new RectShape());
    mDrawable.getPaint().setShader(new LinearGradient(0, 0, 0, h, Color.parseColor("#330000FF"), Color.parseColor("#110000FF"), Shader.TileMode.REPEAT));
    v.setBackgroundDrawable(mDrawable);
}