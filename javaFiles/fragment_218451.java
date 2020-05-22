switch (formatter.formatCellValue(findTitleContents(tempSpreadsheet,"Masking(TB/SM)",i)))
{
    case "SM":  tempScreen.getTreeValue().remove(ScreenStatus.StatusFlag.TB);
     break;
    case "TB":  tempScreen.getTreeValue().add(ScreenStatus.StatusFlag.TB);
       break;
    default :   returnMessage += "Incorrect masking value for row: " + i + "\n, skipping";
                continue;
}

//Unreachable statement
switch (formatter.formatCellValue(findTitleContents(tempSpreadsheet,"3D?(Y/N)",i)))
{
    case "Y": tempScreen.getTreeValue().add(ScreenStatus.StatusFlag.IS3D);
}