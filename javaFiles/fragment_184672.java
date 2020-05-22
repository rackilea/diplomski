ComboBoxCellEditor editor = new ComboBoxCellEditor() {
  @Override
  protected Control createControl( Composite parent ) {
    CCombo combo = ( CCombo )super.createControl( parent );
    combo.setVisibleItemCount( 2 );
    return combo;
  }
};