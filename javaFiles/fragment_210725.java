if (goalReached) {
   // retrieve nearest cell once before modification
   final int nearestCellIndex = returnNearestCell();
   if (nearestCellIndex > -1 && isTarget) {
       // save cell.
       final Cell nearestCell = cells.get(nearestCellIndex);

       if (this.checkCollide(nearestCell.x, nearestCell.y, nearestCell.mass)) {

            // remainder of your code
       }
   }
}