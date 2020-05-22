public class ProductUnitValueProvider extends AbstractPropertyFieldValueProvider implements Serializable, FieldValueProvider {
    @Override
    public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty indexedProperty, final Object model) throws FieldValueProviderException
    {
        if (model instanceof ProductModel)
        {
            //Product model
            final ProductModel product = (ProductModel) model;

            //List of fieldValues to be inflated and returned
            final Collection<FieldValue> fieldValues = new ArrayList<FieldValue>();

            if (product.getUnit() != null)
            {
                //Create fieldValue, just to make it simple as possible however i would perfer to use FieldNameProvider.getFieldNames() instead, to retrieve all FieldNames for this indexedProperty
                String unitName = product.getUnit().getCode();
                fieldValues.add(new FieldValue(indexedProperty.getName(), unitName));
            }
            //Send FieldValues, to be indexed by Solr
            return fieldValues;
        }
        else
        {
            throw new FieldValueProviderException("Error message!");
        }
    }
}