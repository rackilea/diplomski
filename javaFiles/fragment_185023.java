public List<JTextArea> createMultipleCells(int numOfCells) {

         List<JTextArea> cells = new LinkedList<JTextArea>();

          for(int i = 0; i < numOfCells; i++){
            cells.add(new JTextArea(CELL_DIMENSIONS, CELL_DIMENSIONS));
          }

         return cells;
    }