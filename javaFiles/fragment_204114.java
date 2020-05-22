} else if (lineStyleOperators.contains(operatorStr)) {
    if ("w" == operatorStr) {
        cleanUpStrategy.getContext().setLineWidth(((PdfNumber) operands.get(0)).floatValue());
    } else if ("J" == operatorStr) {
        cleanUpStrategy.getContext().setLineCapStyle(((PdfNumber) operands.get(0)).intValue());
    } else if ("j" == operatorStr) {
        cleanUpStrategy.getContext().setLineJoinStyle(((PdfNumber) operands.get(0)).intValue());
    } else if ("M" == operatorStr) {
        cleanUpStrategy.getContext().setMiterLimit(((PdfNumber) operands.get(0)).floatValue());
    } else if ("d" == operatorStr) {
        cleanUpStrategy.getContext().setLineDashPattern(new LineDashPattern(((PdfArray) operands.get(0)),
                ((PdfNumber) operands.get(1)).floatValue()));
    }

    disableOutput = true;