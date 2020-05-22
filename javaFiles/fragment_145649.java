public class AuxiliaryProjectSection extends AdvancedPropertySection {
    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        if (selection instanceof StructuredSelection) {
            Object firstElement = ((StructuredSelection)selection).getFirstElement();
            if (firstElement instanceof IProject) {
                final IProject theProject = (IProject) firstElement;
                ISelection selection2 = new StructuredSelection(new ResourcePropertySource(theProject) {

                    @Override
                    public IPropertyDescriptor[] getPropertyDescriptors() {
                        ArrayList<IPropertyDescriptor>  arrayList = new ArrayList<IPropertyDescriptor>();
                        IPropertyDescriptor[] array = {new PropertyDescriptor("ID-ul", "Labelul")};
                        arrayList.addAll(Arrays.asList(super.getPropertyDescriptors()));
                        arrayList.addAll(Arrays.asList(array));
                        return arrayList.toArray(new IPropertyDescriptor[0]);
                    }

                    @Override
                    public Object getPropertyValue(Object id) {
                        if (id.equals("ID-ul"))
                            return "Silly Value";
                        else
                            return super.getPropertyValue(id);
                    }

                });
                super.setInput(part, selection2); 
            } else {
                super.setInput(part, selection);
            }
        }
    }
}