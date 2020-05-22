for (Object element : results) {
                progress.incrementProgressBy(size / 100);
                if (element instanceof Feature) {
                    Feature feature = (Feature) element;

                    // turn feature into graphic
                    Graphic graphic = new Graphic(feature.getGeometry(),
                            feature.getSymbol(), feature.getAttributes());
                    Polygon p = (Polygon) graphic.getGeometry();
                    p.queryEnvelope(extent);
                    extent.merge(extent);

                    // add graphic to layer
                    mGraphicsLayer.addGraphic(graphic);