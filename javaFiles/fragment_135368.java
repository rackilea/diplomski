ArrayList<TableRow> allRows = new ArrayList<>();
        for (int j = 0; j < tblRoDe.getNumRows(); j++) {
            tblRoDe.setRow(j);
            TableRow trow = new TableRow(tblRoDe.getString("AGR_NAME"), tblRoDe.getString("TEXT"), j);
            allRows.add(trow);
            logger.debug("------- Start Entry #" + trow.getEntryNr() + " -------");
            logger.debug("AGR_Name: " + trow.getAgr_name());
            logger.debug("TEXT: " + trow.getText());
            logger.debug("------- End Entry #" + trow.getEntryNr() + " -------");
        }