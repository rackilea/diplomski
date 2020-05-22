if(getWidth() > getHeight())
                {
                    Matrix scaleMatrix = new Matrix();
                    RectF rectF = new RectF();
                    p.computeBounds(rectF, true);
                    scaleMatrix.setScale(1.6f, .6f,0,0);
                    p.transform(scaleMatrix);
                }
                canvas.drawPath(p, paint);