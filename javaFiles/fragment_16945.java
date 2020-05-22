public void readFile() {
    Label counter = new Label();
    ReadFileTask task = new ReadFileTask();
    counter.textProperty().bind(task.progressProperty().asString());
    new Thread(task).start();
}

public class ReadFileTask extends Task<Void> {

    @Override
    protected Void call() throws Exception {

        File file = new File(pathname); //TODO
        long lines = Files.lines(file.toPath()).count();
        long line = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String zeile = null;
        while ((zeile = reader.readLine()) != null) {
            //TODO do the work

            updateProgress(line++, lines);
        }

        return null;
    }

}