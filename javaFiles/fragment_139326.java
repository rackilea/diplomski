public class ListItemRenderer implements ListitemRenderer,Serializable{

  @override
  public void render(Listitem item,Object data) throws Exception{
   ....
   Listcell lc=new Listcell;
   Textbox text=new Textbox();
   text.setParent(lc);
   lc.setParent(item);
   ....
}
....
}