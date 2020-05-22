...

 columns.add(new AbstractColumn<Contact, String>(new Model<String>("Actions"))
    {
        public void populateItem(Item<ICellPopulator<Contact>> cellItem, String componentId,
            IModel<Contact> model)
        {
            cellItem.add(new ActionPanel(componentId, model));
        }
    });

...

class ActionPanel extends Panel
{
    public ActionPanel(String id, IModel<Contact> model)
    {
        super(id, model);
        add(new Link("select")
        {
            @Override
            public void onClick()
            {
                selected = (Contact)getParent().getDefaultModelObject();
            }
        });
    }
}

public Contact getSelected()
{
    return selected;
}

public void setSelected(Contact selected)
{
    addStateChange();
    this.selected = selected;
}