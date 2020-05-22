private String[] data = new String[PAGE_COUNT];

// ...

pagination.setPageFactory(this::getPage);

public Label getPage(int pageIndex) {

    Label content = null;
    if (pageIndex >= 0 && pageIndex < PAGE_COUNT) {

        if (data[pageIndex] == null) {
            data[pageIndex] = "Content for page " + (pageIndex + 1) + " / " + new Date();
        }
        content = new Label(data[pageIndex]);
        content.setId("Label" + (pageIndex +1));
        //System.out.println(pageIndex+1);
    }

    return content;
}