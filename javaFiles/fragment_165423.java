// first of all, at the class level (assuming listView and manager are both class-level variables, preferably final ones, too):

// An INNER class implementing Runnable which will carry out the searching
private class Searcher implements Runnable {
    private volatile boolean cancelled = false;
    private final String searchTerm;
    Searcher(String searchTerm) {
        this.searchTerm = searchTerm; 
    }

    public void cancel() {
       cancelled = true;
    }

    @Override
    public void run() {
       // remember that there's no guarantee that this will execute before the NEXT keypress, so we add a check to ensure that we still want to perform the search when it gets executed:
       if (!cancelled) {
           manager.searchString(searchTerm);
           Platform.runLater(listViewUpdater); // listViewUpdater is defined below
       }
    }
}

// a Runnable to actually update the GUI after a seach has been performed
private Runnable listViewUpdater = new Runnable(){
    @Override
    public void run() {
        listView.getItems().setAll(manager.getList());
    }
}

private ExecutorService executor = Executors.newSingleThreadExecutor();
private Searcher lastSearcher = null;

// ... then, in the method which sets up the GUI
search.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
            if (lastSearcher != null) {
                lastSearcher.cancel(); // prevents lastSearcher from running if it hasn't done so already
            }
            lastSearcher = new Searcher(s2);
            executor.submit(lastSearcher);
        }
    });