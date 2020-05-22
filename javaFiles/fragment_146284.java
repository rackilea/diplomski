public void setCellStyle(CellStyle style) {
     if(style == null) {
         if(_cell.isSetS()) _cell.unsetS();
     } else {
         XSSFCellStyle xStyle = (XSSFCellStyle)style;
         xStyle.verifyBelongsToStylesSource(_stylesSource);

         long idx = _stylesSource.putStyle(xStyle);
         _cell.setS(idx);
     }
 }