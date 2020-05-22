public RendererAndEditor( StringTableModel model )
{
  renderer = new CellPanel( model );
  editor = new CellPanel( model );

  editor.getRemoveBtn().addActionListener( new ActionListener()
  {
    @Override
    public void actionPerformed( ActionEvent e )
    {
      stopCellEditing();
    }
  });
}