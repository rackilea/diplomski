object LogModel extends AbstractBaseTableModel {

  final val columnNames = Array("Time","Level","Thread","Logger","Message")

  val data = ListBuffer[Array[AnyRef]]()

  def +=:(event: ILoggingEvent) {
    Array[AnyRef](
      formatTimeStamp(event.getTimeStamp),
      event.getLevel,
      event.getThreadName,
      event.getLoggerName.replaceFirst(".*\\.",""),
      event.getFormattedMessage
    ) +=: data
    fireTableChanged( new TableModelEvent(this) )
  }
}