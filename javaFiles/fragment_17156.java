public class ContentDependentImagePainter<T> extends ImagePainter {

    IRowDataProvider<T> dataProvider;

    public ContentDependentImagePainter(IRowDataProvider<T> dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    protected Image getImage(ILayerCell cell, IConfigRegistry configRegistry) {
        // get the row object
        T rowObject = dataProvider.getRowObject(cell.getRowIndex());
        Image result = null;

        // perform your custom logic to determine the Image

        return result;
    }
}