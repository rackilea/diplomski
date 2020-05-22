import scala.collection.SeqLike

abstract class AbstractBaseTableModel extends AbstractTableModel {
  val columnNames: Array[String]

  val data: SeqLike[Array[AnyRef],_]

  def getRowCount: Int = data.size
  def getColumnCount: Int = columnNames.size
  override def getColumnName(column: Int) = columnNames(column)
  override def getValueAt(row: Int, column: Int): AnyRef = data(row)(column)
  override def isCellEditable(row: Int, col: Int) = false

  override def getColumnClass(columnIndex: Int): Class[_] =
    getValueAt(0, columnIndex).getClass

}