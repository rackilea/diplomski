public List<Product> getAllProductsOfType(YourConstantType productType) throws RepositoryException {
        return getProductsByTypeAndScope( 
            getProductTypeId(productType, getAllProductTypes()), 
            getScopeTypeId(Group.SCOPE_TYPE_NAME_HTX, getAvailableScopes()) ,
            getScopeTypeId(Group.SCOPE_TYPE_NAME_PROJECT, getAvailableScopes()) 
        );
}