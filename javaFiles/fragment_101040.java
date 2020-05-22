class Sheet {
    // consider using GORM auto timestamp properties for these Dates...
    Date created
    Date modified

    String title
    int sheetIndex
    String type

    static hasMany = [sheetLayouts : SheetLayout]
}