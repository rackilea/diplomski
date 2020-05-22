public interface Resources extends ClientBundle {
                @Source("progress.gif")
                ImageResource getPreloader();
            }





 Resources resources = GWT.create(Resources.class);
 popup.setWidget(new Image(resources.getPreloader()));