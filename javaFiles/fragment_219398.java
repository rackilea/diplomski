Div div = new Div();
div.add(ls);
div.add(footerFirstParagraph);
div.add(footerSecondParagraph);
div.setFixedPosition(float positionFomleft(50), 
                     float positionFromBottom(30),
                     float widthOfDiv (UnitValue.createPercentValue(float val)));
layoutDocument.add(div);