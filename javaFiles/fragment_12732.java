doc.getMailMerge().setFieldMergingCallback(new IFieldMergingCallback(){
    @Override
    public void fieldMerging(FieldMergingArgs e)throws Exception{
        if(cache.containsKey(e.getFieldName())){
            Document fakeDoc=new Document();
            DocumentBuilder builder=new DocumentBuilder(fakeDoc);
            builder.insertField(e.getField().getFieldCode());
            fakeDoc.getMailMerge().setFieldMergingCallback(new IFieldMergingCallback(){
                @Override
                public void fieldMerging(FieldMergingArgs arg)throws Exception{
                    DocumentBuilder innerBuilder=new DocumentBuilder(arg.getDocument());
                    innerBuilder.moveToMergeField(arg.getFieldName(),false,false);
                    innerBuilder.startBookmark(arg.getFieldName());
                    innerBuilder.moveToMergeField(arg.getFieldName(),true,false);
                    innerBuilder.endBookmark(arg.getFieldName());
                }

                @Override
                public void imageFieldMerging(ImageFieldMergingArgs arg){

                }
            });
            fakeDoc.getMailMerge().execute(new String[]{e.getFieldName()},new Object[]{cache.get(e.getFieldName())});
           // Set the formatted text to the actual field
            e.setText(fakeDoc.getRange().getBookmarks().get(0).getText());
        }
    }

    @Override
    public void imageFieldMerging(ImageFieldMergingArgs args){
    }
});