@RequestMapping(value = "/{supplierId:[0-9]+}", method = RequestMethod.GET)
@ResponseStatus(value = HttpStatus.OK)
@ResponseBody
public SupplierObject get(@PathVariable Long supplierId) 
{
    Supplier supplier = supplierService.get(supplierId);
    SupplierObject supplierObject = new SupplierObject (supplier);
    return SupplierObject;
}