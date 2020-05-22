private static class CombinedWidget extends Composite {

      public CombinedWidget() {
         // place the check above the text box using a vertical panel.
         VerticalPanel panel = new VerticalPanel();
         DockLayoutPanel dPanel = new DockLayoutPanel(Unit.EM);
         panel.setSpacing(13);
         panel.add(nameProject);
         nameProject.setStyleName("gwt-Group-Label");
         panel.add(className);
         panel.add(nameKs);
         panel.add(nameEsmond);
         panel.add(nameBowen);
         panel.add(nameAaron);
         dPanel.addWest(panel, 13);
         dPanel.add(getGeoChart());

         // all composites must call initWidget() in their constructors.
         initWidget(dPanel);

         setWidth("100%");

      }