success: function(data) {
  for (var i = 0; i < data.sudokuArray.length; i++) {
    originalSudoku[i] = data.sudokuArray[i];
    changedSudoku[i] = data.sudokuArray[i];
  }           
}