object LogFrame extends Frame {
  title = "Log"
  iconImage = new ImageIcon("log.png").getImage
  preferredSize = new Dimension(1200,370)

  object LogTable extends Table {
    model = LogModel
    Map(0 -> 50, 1 -> 32, 4 -> 400) foreach { m =>
      peer.getColumnModel getColumn m._1 setPreferredWidth m._2
    }

    override def rendererComponent(
      isSelected: Boolean, focused: Boolean, row: Int, column: Int
    ) = {
      val v = model.getValueAt(
        peer.convertRowIndexToModel(row), 
        peer.convertColumnIndexToModel(column)
      ).toString
      TableCellRenderer.componentFor(this, isSelected, focused, v, row, column)
    }

    import ch.qos.logback.classic.Level.{ERROR,WARN}
    object TableCellRenderer extends AbstractRenderer[String, TextArea](new TextArea {
      lineWrap = true; wordWrap = true
    }) {
      val brown = new java.awt.Color(143,112,0)
      def configure(t: Table, sel: Boolean, foc: Boolean, s: String, row: Int, col: Int) = {
        component.text = s
        model.getValueAt(
          LogTable.this.peer.convertRowIndexToModel(row),
          LogModel.columnNames.indexOf("Level")
        ) match {
          case ERROR => component.foreground = java.awt.Color.RED
          case WARN => component.foreground = brown
          case _ =>
        }
      }
    }
  }

  contents = new BoxPanel(Vertical) {
    contents += new ScrollPane { viewportView = LogTable }
  }

  def logEvent(event: ILoggingEvent) {
    event +=: LogModel
  }

}