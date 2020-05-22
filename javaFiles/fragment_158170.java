this.Message.scaleXProperty().bind(Bindings.createDoubleBinding(() -> {
    return (this.getWidth() - 40.0) / this.Message.getWidth();
}, this.widthProperty())
); this.Message.scaleYProperty().bind(Bindings.createDoubleBinding(() -> {
    return (this.getHeight() - 40.0) / this.Message.getHeight();
}, this.heightProperty()));