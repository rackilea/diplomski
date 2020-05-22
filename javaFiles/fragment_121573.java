CTScaling ctScaling = ...
    ...
    CTValAx ctValAx = ctPlotArea.addNewValAx(); 
    ctValAx.addNewAxId().setVal(123457); //id of the val axis
    ctScaling = ctValAx.addNewScaling();
    ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);

    ctScaling.addNewMin().setVal(0.2);
    ctScaling.addNewMax().setVal(0.7);

    ctValAx.addNewDelete().setVal(false);
    ctValAx.addNewAxPos().setVal(STAxPos.L);
    ctValAx.addNewCrossAx().setVal(123456); //id of the cat axis
    ctValAx.addNewCrosses().setVal(STCrosses.AUTO_ZERO); //this val axis crosses the cat axis at zero
    ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
    ...