@Override
public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo info) {
    super.onCreateContextMenu(menu, v, info);        
    int index = info.position; //The position in the adapter for which the context menu is being displayed. 
    View child = info.targetView;//The child view for which the context menu is being displayed. 
    // so for your case you have to use the child,because of your way about it
    if(child.getId() == R.id.first_button)
         inflate one menu
    else if(child.getId() == R.id.second_button)
         inflate another menu        
}