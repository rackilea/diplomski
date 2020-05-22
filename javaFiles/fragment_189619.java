@Override
public void onClick(View v) {
    String imageTag = v.getTag();
    int position = parentContainer.indexOfChild(v);

    int resultValue = Integer.parseInt(imageTag) + position;
}