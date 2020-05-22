@Override
public void deleteSupply(Long id) {
    Supplies supplies = supplyRepository.findById(id).orElse(null);
    Set<Products> productsList = supplies.getProducts();
    productsList.forEach(products -> products.setSupplies(null));

    supplyRepository.deleteById(id);
}