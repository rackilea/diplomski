//  create mock
    ClassB product = mock(ClassB.class);

    // Define the other mocks from your chain:
    // X, Y, Z, ...

    // define return value for method getProductData()
    when(product.getProductData()).thenReturn(X);
    when(X.offers()).thenReturn(Y);
    when(Y.get(0)()).thenReturn(Z); // And so on.... until the last mock object will return "abc"