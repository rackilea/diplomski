@Override
public void setActiveEditor(IEditorPart part) {

  // TODO check this is your editor

  item.setActionHandler(... get action handler from editor...);

  ITextEditorExtension extension = (ITextEditorExtension)part;
  extension.setStatusField(item, "id");
}