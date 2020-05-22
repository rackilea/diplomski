@Override
public XSLFSlide importContent(XSLFSheet src){
    super.importContent(src);

    XSLFBackground bgShape = getBackground();
    if(bgShape != null) {
        CTBackground bg = (CTBackground)bgShape.getXmlObject();
        if(bg.isSetBgPr() && bg.getBgPr().isSetBlipFill()){
            CTBlip blip = bg.getBgPr().getBlipFill().getBlip();
            String blipId = blip.getEmbed();

            String relId = importBlip(blipId, src.getPackagePart());
            blip.setEmbed(relId);
        }
    }
    return this;
}