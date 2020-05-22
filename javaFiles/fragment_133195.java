@Override
public void start( Stage primaryStage ) throws Exception
{
    HBox box = new HBox();

    // ListView
    ListView<String> list = new ListView<String>( FXCollections.observableArrayList( "Single", "Double", "Suite", "Family App" ) );

    list.setCellFactory( new Callback<ListView<String>, ListCell<String>>()
    {
        @Override
        public ListCell<String> call( ListView<String> param )
        {
            ListCell<String> listCell = new ListCell<String>()
            {
                @Override
                protected void updateItem( String item, boolean empty )
                {
                    super.updateItem( item, empty );
                    setText( item );
                }
            };

            listCell.setOnDragDetected( ( MouseEvent event ) ->
            {
                System.out.println( "listcell setOnDragDetected" );
                Dragboard db = listCell.startDragAndDrop( TransferMode.COPY );
                ClipboardContent content = new ClipboardContent();
                content.putString( listCell.getItem() );
                db.setContent( content );
                event.consume();
            } );

            return listCell;
        }
    } );

    //TreeView
    TreeItem<String> rootItem = new TreeItem<>( "Inbox" );
    rootItem.setExpanded( true );
    for ( int i = 1; i < 6; i++ )
    {
        TreeItem<String> item = new TreeItem<>( "Message " + i );
        rootItem.getChildren().add( item );
    }
    TreeView<String> treeView = new TreeView<>( rootItem );
    treeView.setEditable( true );

    treeView.setCellFactory( new Callback<TreeView<String>, TreeCell<String>>()
    {
        @Override
        public TreeCell<String> call( TreeView<String> stringTreeView )
        {
            TreeCell<String> treeCell = new TreeCell<String>()
            {
                @Override
                protected void updateItem( String item, boolean empty )
                {
                    super.updateItem( item, empty );
                    if ( item != null )
                    {
                        setText( item );
                    }
                }
            };

            treeCell.setOnDragEntered( ( DragEvent event ) ->
            {
                treeCell.setStyle( "-fx-background-color: aqua;" );
            } );

            treeCell.setOnDragExited( ( DragEvent event ) ->
            {
                treeCell.setStyle( "" );
            } );

            treeCell.setOnDragOver( ( DragEvent event ) ->
            {
                Dragboard db = event.getDragboard();
                if ( db.hasString() )
                {
                    event.acceptTransferModes( TransferMode.COPY_OR_MOVE );
                }
                event.consume();
            } );

            treeCell.setOnDragDropped( ( DragEvent event ) ->
            {
                System.out.println( "treeCell.setOnDragDropped" );
                Dragboard db = event.getDragboard();
                boolean success = false;
                if ( db.hasString() )
                {
                    System.out.println( "Dropped: " + db.getString() );
                    treeCell.getTreeItem().getChildren().add( new TreeItem<>( db.getString() ) );
                    treeCell.getTreeItem().setExpanded( true );
                    success = true;
                }
                event.setDropCompleted( success );
                event.consume();
            } );

            return treeCell;
        }
    } );

    box.getChildren().addAll( list, treeView );
    primaryStage.setScene( new Scene( box ) );
    primaryStage.show();
}