public class syncedFolders {

    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty location = new SimpleStringProperty();
    private SimpleStringProperty dateModified = new SimpleStringProperty();
    private SimpleDoubleProperty size = new SimpleDoubleProperty();

    public syncedFolders(
            String name,
            String location,
            String dateModified,
            double size) {

        this.name.set(name);
        this.location.set(location);
        this.dateModified.set(dateModified);
        this.size.setValue(size);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLocation() {
        return location.get();
    }

    public SimpleStringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getDateModified() {
        return dateModified.get();
    }

    public SimpleStringProperty dateModifiedProperty() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified.set(dateModified);
    }

    public double getSize() {
        return size.get();
    }

    public SimpleDoubleProperty sizeProperty() {
        return size;
    }

    public void setSize(double size) {
        this.size.set(size);
    }
}