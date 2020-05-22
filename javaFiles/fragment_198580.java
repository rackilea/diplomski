doc.getTables().stream()
        .map(XWPFTable::getRows).flatMap(List::stream)
        .map(XWPFTableRow::getTableCells).flatMap(List::stream)
        .map(XWPFTableCell::getParagraphs).flatMap(List::stream)
        .map(XWPFParagraph::getRuns).flatMap(List::stream)
        .filter(Objects::nonNull)
        .forEach(xwpfRun -> {
            String text = xwpfRun.getText(0);
            if (text != null && text.contains(key)) {
                text = text.replace(key, replaces.get(key) == null ? "" : replaces.get(key));
                xwpfRun.setText(text, 0);
            }
});