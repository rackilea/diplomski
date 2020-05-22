NodeList sections = mergedDoc.getElementsByTagName("trkpt");
Set<Element> targetElements = new HashSet<Element>();
int nTr = sections.getLength();
for (int i = 0; i < nTr; i++) {
    Element trackPt = (Element) sections.item(i);

    //................
    //removed not relevant code for answer.....
    //.......

    //
    if (time < (tcxStartTime.getTime()-5000) || time > (tcxEndTime.getTime()+5000)){
        targetElements.add(trackPt);
    }

}


for (Element trackPt: targetElements) {
    trackPt.getParentNode().removeChild(trackPt);
}