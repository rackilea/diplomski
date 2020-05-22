for (int rowIdx = deletedrow; rowIdx < sheet.getRows(); rowIdx++) {
                    for (int colIdx = 0; colIdx < sheet.getColumns(); colIdx++) {
                        Cell readCell = sheet.getCell(colIdx, rowIdx+1);
                        Label label = new Label(colIdx, rowIdx, readCell.getContents());
                        CellFormat readFormat = readCell.getCellFormat();
                        if (readFormat != null) {

                            label.setCellFormat(readFormat);
                        }
                        sheet.addCell(label);
                    }

                }
sheet.removeRow(sheet.getRows());