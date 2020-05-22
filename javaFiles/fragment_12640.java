class TemporaryHolderTreeItem(picture: Picture) extends TreeItem[Picture](picture) {

  private val gridPane = new GridPane
  private val progressBar = new ProgressBar {
    prefWidth = 250
  }
  private val columnConstraints = ObservableBuffer(
    new ColumnConstraints(500),
    new ColumnConstraints(250)
  )

  gridPane.addColumn(0, new Label(resourceBundle
    .getString("uploadHolderText") + " " + picture.path))

  gridPane.addColumn(1, progressBar)

  gridPane.columnConstraints = columnConstraints
  graphic = gridPane

}