...
public class MyXMLTableTreeViewer extends XMLTableTreeViewer implements IResourceChangeListener{
....

public MyXMLTableTreeViewer(Composite parent, IEditorPart parentEditor)
{
   super(parent);
   ....
   Point size = getControl().getSize();
   size.x = 1000;
   getControl().setSize(size);
}