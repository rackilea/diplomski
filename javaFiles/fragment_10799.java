// Setup a sheet to copy
Sheet sheet = new Sheet();
sheet.setFromId(7298027523204996L);
// Copy the sheet
Sheet newSheet = smartsheet.sheets().createSheetFromExisting(sheet, EnumSet.allOf(ObjectInclusion.class));
// Setup what we will publish
SheetPublish sheetPublish = new SheetPublish.PublishStatusBuilder().setIcalEnabled(false).setReadOnlyFullEnabled(false).
        setReadOnlyLiteEnabled(false).setReadWriteEnabled(true).build();
// publish the new sheet
SheetPublish sheetPublishResult = smartsheet.sheets().updatePublishStatus(newSheet.getId(), sheetPublish);
System.out.println(sheetPublishResult.getReadWriteUrl());