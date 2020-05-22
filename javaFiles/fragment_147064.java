PDFTextStripper stripper = new PDFTextStripper() {
    @Override
    protected void processTextPosition(TextPosition text) {
        PDGraphicsState gs = getGraphicsState();
        PDColor color = gs.getNonStrokingColor();
        float[] currentComponents = color.getComponents();
        if (!Arrays.equals(components, currentComponents)) {
            System.out.print(Arrays.toString(currentComponents));
            components = currentComponents;
        }
        System.out.print(text.getUnicode());
        super.processTextPosition(text);
    }

    float[] components;
};

stripper.addOperator(new SetNonStrokingColorSpace());
stripper.addOperator(new SetNonStrokingColorN());