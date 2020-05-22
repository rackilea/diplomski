public WritableRaster More ...createWritableChild(int parentX, int parentY,
                                              int w, int h,
                                             int childMinX, int childMinY,
                                             int bandList[]) {
        if (parentX < this.minX) {
            throw new RasterFormatException("parentX lies outside raster");
        }
        if (parentY < this.minY) {
            throw new RasterFormatException("parentY lies outside raster");
        }
        if ((parentX+w < parentX) || (parentX+w > this.width + this.minX)) {
            throw new RasterFormatException("(parentX + width) is outside raster");
        }
        if ((parentY+h < parentY) || (parentY+h > this.height + this.minY)) {
            throw new RasterFormatException("(parentY + height) is outside raster");
        }

        SampleModel sm;
        // Note: the SampleModel for the child Raster should have the same
        // width and height as that for the parent, since it represents
        // the physical layout of the pixel data.  The child Raster's width
        // and height represent a "virtual" view of the pixel data, so
        // they may be different than those of the SampleModel.
        if (bandList != null) {
            sm = sampleModel.createSubsetSampleModel(bandList);
        }
        else {
            sm = sampleModel;
        }

        int deltaX = childMinX - parentX;
        int deltaY = childMinY - parentY;

        return new WritableRaster(sm,
                                  getDataBuffer(),
                                  new Rectangle(childMinX,childMinY,
                                                w, h),
                                  new Point(sampleModelTranslateX+deltaX,
                                            sampleModelTranslateY+deltaY),
                                 this);
    }