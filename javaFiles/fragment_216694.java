for(PDAnnotation an :anotn) {
                PDRectangle rec = an.getRectangle();

                PDRectangle currentSourcePageMBox = currentSourcePage.getMediaBox();

                boolean isLandscape = currentSourcePageMBox.getWidth() > currentSourcePageMBox.getHeight();

                if(isLandscape) {

                    rec.setLowerLeftY(((rec.getLowerLeftY()) * scaleFactor) + 180 + 2 * ypos);
                    rec.setUpperRightY(((rec.getUpperRightY()) * scaleFactor) + 180 + 2*ypos);
                }
                else {
                    rec.setLowerLeftY(((rec.getLowerLeftY()) * scaleFactor) +  ypos);
                    rec.setUpperRightY(((rec.getUpperRightY()) * scaleFactor) +  ypos);
                }

                rec.setLowerLeftX((rec.getLowerLeftX() + xpos) * scaleFactor);
                rec.setUpperRightX((rec.getUpperRightX() + xpos ) * scaleFactor);                   

                an.setRectangle(rec);
            }

            // get all annotations and set on the new page.
            page.setAnnotations(currentSourcePage.getAnnotations());