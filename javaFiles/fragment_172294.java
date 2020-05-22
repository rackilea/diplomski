if (item.getUserObject() instanceOf Sun) {
    Sun first=(Sun) item.getUserObject();
    ....;
} else if (item.getUserObject() instanceOf Wall) {
    Wall second=(Wall) item.getUserObject();
    ...;
} else  if (item.getUserObject() instanceOf Sky) {
    Sky third=(Sky) item.getUserObject();
    ...;
}