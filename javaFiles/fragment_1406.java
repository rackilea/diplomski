else if (op.getOperation().equals("TJ"))
{
    COSArray previous = (COSArray) tokens.get(o - 1); 
    for (int k = 0; k < previous.size(); k++)  
    {
        Object arrElement = previous.getObject(k);
        if (arrElement instanceof COSString)  
        {
            COSString cosString = (COSString) arrElement; 
            String string = cosString.getString(); 
            // i get errors in the instructions below 
            tokens.set(o-1, COSInteger.get(3));
            tokens.set(o, PDFOperator.getOperator("Tr"));
            tokens.add(++o, new COSString(string));
            tokens.add(++o, PDFOperator.getOperator("TJ"));
            tokens.add(++o, COSInteger.get(0));
            tokens.add(++o, PDFOperator.getOperator("Tr"));
            tokens.add(++o, new COSString(""));
            tokens.add(++o, PDFOperator.getOperator("TJ"));
        }
    }
}