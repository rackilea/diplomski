//Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer();
        String newLine = "<br>";
        String toolTipText = "<html>Snowboarding"+newLine+"Rowing"+newLine+"Knitting"+newLine+"Speed reading"+newLine+"Pool"+newLine+"None of the above</html>";
        renderer.setToolTipText(toolTipText);
        sportColumn.setCellRenderer(renderer);