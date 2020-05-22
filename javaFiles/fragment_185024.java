public JTextArea[] createMultipleCells(int numOfCells) {

             JTextArea[] cells = new JTextArea[numOfCells];

              for(int i = 0; i < numOfCells; i++){
                cells[i] = new JTextArea(CELL_DIMENSIONS, CELL_DIMENSIONS);
              }

             return cells;
        }