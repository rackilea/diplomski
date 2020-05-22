ShapeDrawable sd1 = new ShapeDrawable(new RectShape());
                        sd1.getPaint().setColor(CommonUtilities.color);
                        sd1.getPaint().setStyle(Style.STROKE);
                        sd1.getPaint().setStrokeWidth(CommonUtilities.stroke);
                        sd1.setPadding(15, 10, 15, 10);

                        sd1.getPaint().setPathEffect(
                                new CornerPathEffect(CommonUtilities.corner));
                        ln_back.setBackgroundDrawable(sd1);