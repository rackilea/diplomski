SectPr sectPr = null;
if(isLastSection){
    List<SectionWrapper> sections = wordprocessingMLPackage.getDocumentModel().getSections();
    sectPr = sections.get(sections.size() - 1).getSectPr();
    if (sectPr==null ) {
        sectPr = objectFactory.createSectPr();
        wordprocessingMLPackage.getMainDocumentPart().addObject(sectPr);
        sections.get(sections.size() - 1).setSectPr(sectPr);
    }
}
else{
    sectPr = objectFactory.createSectPr();
}