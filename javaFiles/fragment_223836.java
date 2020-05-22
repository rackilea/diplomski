String[] cellStrings = "A2:A8".split(":");
    CellReference start = new CellReference(cellStrings[0]);
    CellReference end = new CellReference(cellStrings[1]);

    CellRangeAddress address = new CellRangeAddress(start.getRow(),
            end.getRow(), start.getCol(), end.getCol());
    System.out.println(address);