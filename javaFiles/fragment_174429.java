@Override 
public void onPreviewFrame(byte[] data, Camera camera) { 
   Bitmap bitmap = Bitmap.createBitmap(r.width(), r.height(), Bitmap.Config.ARGB_8888);
    Allocation bmData = renderScriptNV21ToRGBA888(
        mContext,
        r.width(),
        r.height(),
        data);
    bmData.copyTo(bitmap);
}

public Allocation renderScriptNV21ToRGBA888(Context context, int width, int height, byte[] nv21) {
  RenderScript rs = RenderScript.create(context);
  ScriptIntrinsicYuvToRGB yuvToRgbIntrinsic = ScriptIntrinsicYuvToRGB.create(rs, Element.U8_4(rs));

  Type.Builder yuvType = new Type.Builder(rs, Element.U8(rs)).setX(nv21.length);
  Allocation in = Allocation.createTyped(rs, yuvType.create(), Allocation.USAGE_SCRIPT);

  Type.Builder rgbaType = new Type.Builder(rs, Element.RGBA_8888(rs)).setX(width).setY(height);
  Allocation out = Allocation.createTyped(rs, rgbaType.create(), Allocation.USAGE_SCRIPT);

  in.copyFrom(nv21);

  yuvToRgbIntrinsic.setInput(in);
  yuvToRgbIntrinsic.forEach(out);
  return out;
}