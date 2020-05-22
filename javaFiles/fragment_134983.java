CartesianCoordinate startingPoint = new CartesianCoordinate(1,3);
CartesianCoordinate rightUpDiag = startingPoint.getAClone(),leftUpDiag = startingPoint.getAClone(),rightDownDiag = startingPoint.getAClone(),leftDownDiag = startingPoint.getAClone();
for(int counter = 0 ;counter < 100; counter ++) {
   System.out.println(rightUpDiag.moveCoordinateByStepSize(Direction.DIAGONAL_RIGHT_UP,1));
   System.out.println(leftUpDiag.moveCoordinateByStepSize(Direction.DIAGONAL_LEFT_UP,1));
   System.out.println(rightDownDiag.moveCoordinateByStepSize(Direction.DIAGONAL_RIGHT_DOWN,1));
   System.out.println(leftDownDiag.moveCoordinateByStepSize(Direction.DIAGONAL_LEFT_DOWN,1));
}