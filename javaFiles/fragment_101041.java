class SheetLayout {
    String size
    int xPosition
    int yPosition

    Sheet sheet

    static belongsTo = [sheet : Sheet]
}