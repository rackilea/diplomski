public static BufferedImage filter(BufferedImageOp var0, BufferedImage var1, BufferedImage var2) {

  ...
        BufferedImage var3 = null;
        switch(getNativeOpIndex(var0.getClass())) {
        case 0:
            LookupTable var4 = ((LookupOp)var0).getTable();
            if (var4.getOffset() != 0) {
                return null;
            }

            if (var4 instanceof ByteLookupTable) {
                ByteLookupTable var9 = (ByteLookupTable)var4;
                if (lookupByteBI(var1, var2, var9.getTable()) > 0) {
                    var3 = var2;
                }
            }
            break;
        case 1:
            AffineTransformOp var5 = (AffineTransformOp)var0;
            double[] var6 = new double[6];
            AffineTransform var7 = var5.getTransform();
            var5.getTransform().getMatrix(var6);
            if (transformBI(var1, var2, var6, var5.getInterpolationType()) > 0) {
                var3 = var2;
            }
            break;
        case 2:
            ConvolveOp var8 = (ConvolveOp)var0;
            if (convolveBI(var1, var2, var8.getKernel(), var8.getEdgeCondition()) > 0) {
                var3 = var2;
            }
        }

        if (var3 != null) {
            SunWritableRaster.markDirty(var3);
        }

        return var3;
    }
}