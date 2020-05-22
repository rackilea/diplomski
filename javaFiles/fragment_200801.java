public static void processRawXML(String filename, String exchange, String symbol) throws Exception {
    try {

        List<String> segSheetlist = new ArrayList<String>();

        File fXmlFile = new File(filename);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getDocumentElement().getElementsByTagName("segmentsheetentity");
        System.out.println("node name=" + doc.getDocumentElement().getTagName());

        System.out.println("node length=" + nList.getLength());

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) nNode;
                if (eElement.getElementsByTagName("SegmentDetailEntityList").getLength() > 0) {

                    NodeList ndetailList = doc.getDocumentElement().getElementsByTagName("SegmentDetailEntityList").item(0).getChildNodes();
                    if(ndetailList.getLength()>0){
                        for (int temp1 = 0; temp1 < ndetailList.getLength(); temp1++) {

                            Node ndetailNode = ndetailList.item(temp1);


                              if(ndetailNode.getNodeName().equalsIgnoreCase("SegmentDetailEntity")){

                                  Element eElement1 = (Element) ndetailNode;
                                  if (eElement1.getElementsByTagName("SegmentReportDetailEntityList").getLength() > 0){

                                      NodeList nSegmentReportDetailEntityList = eElement1.getChildNodes();
                                       if(nSegmentReportDetailEntityList.getLength()>0){
                                           for (int temp2 = 0; temp2 < nSegmentReportDetailEntityList.getLength(); temp2++){
                                               Node nreportdetailNode = nSegmentReportDetailEntityList.item(temp2);
                                               if(nreportdetailNode.getNodeName().equalsIgnoreCase("SegmentReportDetailEntityList")){
                                               System.out.println("\nCurrent Element balancesheet:" + nreportdetailNode.getNodeName());
                                               Element eElement2 = (Element) nreportdetailNode;
                                               NodeList nSegmentReportDetailEntity = eElement2.getChildNodes();
                                                for(int temp3=0;temp3<nSegmentReportDetailEntity.getLength();temp3++){
                                                    Node nreportNode = nSegmentReportDetailEntity.item(temp3);
                                                    if(nreportNode.getNodeName().equalsIgnoreCase("SegmentReportDetailEntity")){
                                                    Element eElement3 = (Element) nreportNode;
                                                     System.out.println("\nCurrent t##############:" + nreportNode.getNodeName());
                                                     if (eElement3.getElementsByTagName("DataName").getLength() > 0) {
                                                        segSheetlist.add(eElement3.getElementsByTagName("DataName").item(0).getFirstChild().getNodeValue());
                                                        System.out.println("DataName : " + eElement3.getElementsByTagName("DataName").item(0).getFirstChild().getNodeValue());
                                                    } else {
                                                        segSheetlist.add("");
                                                    }
                                                     if (eElement3.getElementsByTagName("DataValue").getLength() > 0) {
                                                            segSheetlist.add(eElement3.getElementsByTagName("DataValue").item(0).getFirstChild().getNodeValue());
                                                            System.out.println("DataValue : " + eElement3.getElementsByTagName("DataValue").item(0).getFirstChild().getNodeValue());
                                                        } else {
                                                            segSheetlist.add("");
                                                        }
                                                     if (eElement3.getElementsByTagName("CalculationIndicator").getLength() > 0) {
                                                        segSheetlist.add(eElement3.getElementsByTagName("CalculationIndicator").item(0).getFirstChild().getNodeValue());
                                                        System.out.println("CalculationIndicator : " + eElement3.getElementsByTagName("CalculationIndicator").item(0).getFirstChild().getNodeValue());
                                                    } else {
                                                        segSheetlist.add("");
                                                    }
                                                    }
                                                }

                                               }
                                           }
                                       }
                                  }
                              }
                        }
                    }

                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e.getMessage() + " at processRawXML");
        StackTraceElement[] st = e.getStackTrace();
        for (int i = 0; i < st.length; i++) {
            System.out.println(st[i].toString());
        }

    }
}