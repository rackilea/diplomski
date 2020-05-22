MockitoAnnotations.initMocks(this);
// [1]
mealTransformer.transform(any(), any(), any(), any());
//              [6]       [2]    [3]    [4]    [5]
// test passes! now the next test
MockitoAnnotations.initMocks(this);
// [7]
mealTransformer.transform(any(), any(), any(), any());
//              [12]      [8]    [9]    [10]   [11]