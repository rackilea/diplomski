Workbook mockWorkbook = mock(Workbook.class);
Sheet mockSheet = mock(Sheet.class);
Row mockRow = mock(Row.class);
Cell mockCell = mock(Cell.class);
when(mockWorkbook.createSheet("Conference Details")).thenReturn(mockSheet);
when(mockSheet.createRow(0)).thenReturn(mockRow);
when(mockSheet.createRow(anyInt())).thenReturn(mockRow);
when(mockRow.createCell(anyInt())).thenReturn(mockCell);

Sheet sheet = mockTalkDetailsToExcel.createAndReturnSheetFromWorkbook(mockWorkbook);