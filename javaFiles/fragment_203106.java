VoidResult voidResult = null;
try {
    // some code getting to a voidResult
} catch (Exception e) { 
    // some code dealing with this eception
}
if (voidResult != null && voidResult.errorGenerated()) {
    // throw ResponseError
}