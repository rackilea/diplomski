public static float getAvailableHeight(PdfDocument pdfDocument) {
    Float indentBottom = pdfDocument.bottomMargin();
    try {
        Method method = pdfDocument.getClass().getDeclaredMethod("indentBottom");
        method.setAccessible(true);
        indentBottom = (Float) method.invoke(pdfDocument);
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
    float offset = pdfDocument.top() - pdfDocument.getVerticalPosition(false);
    return pdfDocument.getPageSize().getHeight() - offset - pdfDocument.topMargin()  - indentBottom
            - pdfDocument.bottomMargin();
}