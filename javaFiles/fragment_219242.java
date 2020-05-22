Iterator<?> iter = model.getAnnotationIterator();
while (iter.hasNext()) {
  Object object = iter.next();
  if (object instanceof MarkerAnnotation) {
    MarkerAnnotation annotation = (MarkerAnnotation)object;

    IMarker marker = annotation.getMarker();

    // TODO check this is the marker you are interested in

    Position position = model.getPosition(annotation);
  }
}