@WebResult(name = "getProductListResponse", targetNamespace = "http://v3.core.com.productserve.com/", partName = "return")
@WebMethod
public GetProductListResponse getProductList(
    @WebParam(partName = "parameters", name = "getProductList", targetNamespace = "http://v3.core.com.productserve.com/")
    GetProductList parameters
) throws ApiException;