public class ElementModel<T> implements IModel<T>
{
    private static final long serialVersionUID = 1L;

    /** The list model */
    private IModel<List<T>> listModel;

    /** The list item's index */
    private final int index;

    /**
     * Construct
     * 
     * @param listModel
     *            The list model
     * @param index
     *            The index of this model
     */
    public ElementModel(final IModel<List<T>> listModel, final int index)
    {
        this.listModel = listModel;
        this.index = index;
    }

    /**
     * @see org.apache.wicket.model.IModel#getObject()
     */
    @Override
    public T getObject()
    {
        return listModel.getObject().get(index);
    }

    /**
     * @see org.apache.wicket.model.IModel#setObject(java.lang.Object)
     */
    @Override
    public void setObject(T object)
    {
        listModel.getObject().set(index, object);
    }

    /**
     * @see org.apache.wicket.model.IDetachable#detach()
     */
    @Override
    public void detach()
    {
        // Do nothing.
    }
}