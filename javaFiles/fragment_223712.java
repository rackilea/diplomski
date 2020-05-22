//define framedPanel for later use
private FramedPanel fupanel;

//Instantiate the widget i want to add when the option is clicked
final FileUp fileUp = new FileUp();

//Create the HtmlLayoutContainer in which add the widget later on

HtmlLayoutContainer conEnlaces = new HtmlLayoutContainer(getTablaEnlaces());

public Widget asWidget() {
    if (fupanel == null) {
        fupanel = new FramedPanel();
        fupanel.setHeadingText("Administración");
        (some other code here)

      VerticalLayoutContainer p = new VerticalLayoutContainer();      

      conEnlaces.setWidth(Window.getClientWidth());

      fupanel.add(p);

      p.add(conEnlaces);

      Hyperlink fileUph = new Hyperlink();
      fileUph.setText("- Importación de CSV");
      conEnlaces.add(fileUph, new HtmlData(".fileUph"));  

      filexh.addClickHandler(new ClickHandler() {

        @Override
        public void onClick(ClickEvent event) {
            conEnlaces.add(filex, new HtmlData(".resultado"));

        }
    });

        fupanel.add(conEnlaces);
    }
    return fupanel;
  }

private native String getTablaEnlaces() /*-{
  return [ '<table border="0" cellspacing="0" cellpadding="0">',
      '<tr><td>',
      '<table border="0" width="75%">',
      '<tr><td class=fileUph></td></tr>',     
      '</table></td>',
      '<td><table border="0" style="margin-left: 25px;">',
      '<tr><td class=resultado></td></tr>',
      '</table>',
      '</td></tr></table>'
  ].join("");
}-*/;               

public void onModuleLoad() {
    RootPanel.get().add(asWidget());
  }