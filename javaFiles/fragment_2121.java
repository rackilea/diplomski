for(int ptCnt=0; ptCnt < productTypeNL.getLength(); ptCnt++) {
    Node productTypeNode = productTypeNL.item(ptCnt);
    if(productTypeNode.hasChildNodes()){
        NodeList childProductTypeNL = productTypeNode.getChildNodes();
        System.out.print("Product Types are: ");
        for (int cptCnt=0; cptCnt < childProductTypeNL.getLength(); cptCnt++) {
            productTypeBean = new ProductType();
            productTypeBean.setmProductType (
                            childProductTypeNL.item(cptCnt).getTextContent());
            System.out.print(productTypeBean.getmProductType() + ", ");
            ProductTypeAL.add(productTypeBean);
        }
    }
    productBean.setmProductTypes(ProductTypeAL);
}