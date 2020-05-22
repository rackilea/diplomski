public class ImageAdapter extends ArrayAdapter<ImageInformation> {

    List<ImageInformation> imageInformationList;

    //rename parameter name:
    public ImageAdapter(Context context, List<ImageInformation> imageInformationListParameter) {
        super(context, R.layout.more_details_images, imageInformationListParameter);

        imageInformationList = imageInformationListParameter; //added
    }

   //.................