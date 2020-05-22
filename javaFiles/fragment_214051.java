if (yuvType == null)
{
    yuvType = new Type.Builder(rs, Element.U8(rs)).setX(dataLength);
    in = Allocation.createTyped(rs, yuvType.create(), Allocation.USAGE_SCRIPT);

    rgbaType = new Type.Builder(rs, Element.RGBA_8888(rs)).setX(prevSizeW).setY(prevSizeH);
    out = Allocation.createTyped(rs, rgbaType.create(), Allocation.USAGE_SCRIPT);
}

in.copyFrom(data);

yuvToRgbIntrinsic.setInput(in);
yuvToRgbIntrinsic.forEach(out);

Bitmap bmpout = Bitmap.createBitmap(prevSizeW, prevSizeH, Bitmap.Config.ARGB_8888);
out.copyTo(bmpout);