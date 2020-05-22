public class ModelBasedWizard extends Wizard implements IModelBasedWizard {
    //UI, pages, stati and all other functionalities are already implemented.
    //I just need to bind this wizard to a model

    //create some content here

    @Override
    public void bindModel(IModel model) {
        this.model = model;
        this.fieldOne.bindToModel(model);
        model.addPropertyChangeListener(new PropertyChangeListener() {
            //bla bla
        });
    }
}