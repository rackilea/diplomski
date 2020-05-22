public class NotesLoader extends SwingWorker<List<Properties>, Properties> {

    @Override
    protected List<Properties> doInBackground() throws Exception {
        List<Properties> notes = new ArrayList<>(25);
        File[] files = new File(".").listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".properties");
            }
        });

        for (File file : files) {
            int count = 0;
            try (Reader reader = new FileReader(file)) {
                Properties note = new Properties();
                note.load(reader);

                notes.add(note);
                publish(note);
                setProgress((int) ((count / (double) files.length) * 100d));
            }
        }

        return notes;
    }

}