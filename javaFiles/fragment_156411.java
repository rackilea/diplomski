if(object instanceof TextureMapObject) {
        TextureMapObject mapObject = (TextureMapObject) object;
        this.bounds = new Rectangle(mapObject.getX(), mapObject.getY(),
                                    mapObject.getTextureRegion().getRegionWidth(),
                                    mapObject.getTextureRegion().getRegionHeight());
    }
    else
        this.bounds = ((RectangleMapObject) object).getRectangle();