public void populateHiddenSheet(int categoryNumber, int genderNumber, ArrayList<Player> players,
        ArrayList<Player> overankedPlayers)
{
    DataValidationConstraint constraint = null;
    DataValidationHelper validationHelper = null;
    String name = new String();

    Sheet hiddenSheet = workbook.getSheet(HIDDEN_SHEET_NAME);

    // Creates the hidden sheet if it does not exist
    if (hiddenSheet == null)
    {
        hiddenSheet = workbook.createSheet(HIDDEN_SHEET_NAME);
        workbook.setSheetHidden(workbook.getSheetIndex(HIDDEN_SHEET_NAME), Workbook.SHEET_STATE_VERY_HIDDEN);

    }

    // Adds the list of player names in the sheet
    for (int i = 0; i < players.size(); i++)
    {
        name = players.get(i).getName();

        POIExcelFileProcessor.createCell(hiddenSheet, columnNumber, i, NAME_PREFIX + name);
    }

    // Sets the validation for the drop-down lists
    validationHelper = hiddenSheet.getDataValidationHelper();
    constraint = validationHelper.createFormulaListConstraint(HIDDEN_SHEET_NAME + "!$" + (char) (columnNumber + 65)
            + "$1:$" + (char) (columnNumber + 65) + "$" + (players.size() + overankedPlayers.size() + 1));

    listConstraints.add(constraint);
}