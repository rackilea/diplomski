abstract class Matrix {
  def get(r: Int, c: Int): Double
  def numRows: Int
  def numCols: Int
}

case class RowMatrix(rows: Array[Row]) extends Matrix {
  def get(r: Int, c: Int): Double = rows(r)(c)
  def numRows: Int = rows.length
  def numCols: Int = rows(0).length
}

case class ColumnMatrix(cols: Array[Column]) extends Matrix {
  def get(r: Int, c: Int): Double = cols(c)(r)
  def numRows: Int = cols(0).length
  def numCols: Int = cols.length
}