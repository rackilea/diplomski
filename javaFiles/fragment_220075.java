The actual solution is:-

Style tStyle = (Style)rPr.getParent();
if( tStyle.getRPr().getI().isVal()){
   isItalic = true;
}