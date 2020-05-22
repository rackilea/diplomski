{
    ....
    table.getColumnModel().getColumn(2).setCellRenderer(
        new ThickRightBorderCellRenderer());
    ....
  }

  private static class ThickRightBorderCellRenderer
          extends DefaultTableCellRenderer {

    @Override
    public Border getBorder() {
      return BorderFactory.createMatteBorder(0, 0, 0, 3, Color.BLACK);
    }
  }