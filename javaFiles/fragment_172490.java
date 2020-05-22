double totalCostOfSelectedItems = 0 ;
for (Data product : productSelected) {
    totalCostOfSelectedItems = totalCostOfSelectedItems + product.getRTotal();
}
finalCost = finalCost - totalCostOfSelectedItems() ;

allProducts.removeAll(productSelected);