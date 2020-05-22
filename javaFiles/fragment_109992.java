...
        //val axis
        CTValAx ctValAx = ctPlotArea.addNewValAx(); 
        ctValAx.addNewAxId().setVal(123457); //id of the val axis
        ctScaling = ctValAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctValAx.addNewDelete().setVal(false);
        ctValAx.addNewAxPos().setVal(STAxPos.L);
        ctValAx.addNewCrossAx().setVal(123456); //id of the cat axis
        ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //colored major gridlines
        ctValAx.addNewMajorGridlines().addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[]{(byte)255,0,0});

        //colored axis line
        ctValAx.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[]{(byte)255,0,0});

        //axis font
        org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody ctTextBody
         = ctValAx.addNewTxPr(); //text body properties
        ctTextBody.addNewBodyPr(); //body properties
        org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties ctTextCharacterProperties 
         = ctTextBody.addNewP().addNewPPr().addNewDefRPr(); //character properties
        ctTextCharacterProperties.setSz(12*100); //size in 100th of a point
        ctTextCharacterProperties.addNewSolidFill().addNewSrgbClr().setVal(new byte[]{(byte)255,0,0}); //color
...