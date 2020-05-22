int innerIndex = 0;
for(int i = 0;i<rowHeadingkeys.length;i++) {

    if(rowHeadingkeys!=null) {

        patientMonitoringTable.addCell(createCell(rowHeadingkeys[i],
                PDFUtil.BOLD_FONT,1,Element.ALIGN_LEFT));

        for(int j = 0;j<rowValuekeys.length/rowHeadingkeys.length;j++) {
      if(innerIndex < rowValuekeys.length)
            patientMonitoringTable.addCell(createCell(svo.getFields().get(rowValuekeys[innerIndex]).getValue(),
                    PDFUtil.FONT,1,Element.ALIGN_LEFT));
           innerIndex++;
        }

    }