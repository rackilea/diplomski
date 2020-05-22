class CustomEditTextCell extends EditTextCell{
    @Override
    public void render(com.google.gwt.cell.client.Cell.Context context,
            String value, SafeHtmlBuilder sb) {
        // context.getColumn()==2 indicate Record ID column and context.getIndex()==0 indicate non editable cell in 1st empty row
        if(context.getColumn()==2 &&    ( context.getIndex()==0  || context.getIndex()%10 == 0)){
            sb.appendHtmlConstant("<div contentEditable='false' unselectable='true'></div>");
        }else{
        super.render(context, value, sb);
        }

    }
}