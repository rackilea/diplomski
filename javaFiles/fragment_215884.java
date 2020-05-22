private void updateIcons(ImageView imageView, String statusValue, String checkValue1, String checkValue2,
                         int image1, int image2) {

    if (statusValue == null || statusValue.equals(checkValue1)) {

        imageView.setImageResource(image1);

    } else if (statusValue.equals(checkValue2)) {

        imageView.setImageResource(image2);

    }

}