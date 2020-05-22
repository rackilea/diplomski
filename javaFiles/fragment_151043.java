/**
 * Abstract class for textfields used for filtering.
 * @author fred
 *
 */

public abstract class FilterStringPanel extends Panel {

private static final long serialVersionUID = 1L;
private FilterForm filterForm;

public FilterStringPanel(String id) {
    super(id);
    filterForm = new FilterForm("filterForm");
    add(filterForm);
}

public String getFilterString(){
    return filterForm.getFilterString();
}

/**
 *For developers to implement in class that contains the correct references to params and facade objects, dataviews etc.
 *e.g. they could do params.setFilter(<reference to an instance of this class>.getFilterString() and ajax stuff too) 
 */
public abstract void onUpdateFilter(AjaxRequestTarget target);

private class FilterForm extends Form<Void> {

    private static final long serialVersionUID = 1L;
    private transient String filterString;

    public FilterForm(String id) {
        super(id);
        final TextField<String> filterTextField = new TextField<String>("filterTextField", new PropertyModel<String>(this, "filterString")); //textField for user to enter filter string
        add(filterTextField);

        add(new AjaxButton("filterButton") { //button to click for performing overriden method
            private static final long serialVersionUID = 1L;
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                onUpdateFilter(target);
            }
        }); 
    }

    public String getFilterString(){
        return filterString;
    }   
}
}