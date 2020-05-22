public class PDFLineRecordReader extends RecordReader<Text, Text> {

private Text key = new Text();
private Text value = new Text();
private int currentLine = 0;
private List<String> lines = null;

private PDDocument doc = null;
private PDFTextStripper textStripper = null;

@Override
public void initialize(InputSplit split, TaskAttemptContext context)
        throws IOException, InterruptedException {

    FileSplit fileSplit = (FileSplit) split;
    final Path file = fileSplit.getPath();

    Configuration conf = context.getConfiguration();
    FileSystem fs = file.getFileSystem(conf);
    FSDataInputStream filein = fs.open(fileSplit.getPath());

    if (filein != null) {

        doc = PDDocument.load(filein);

        // Konnte das PDF gelesen werden?
        if (doc != null) {
            textStripper = new PDFTextStripper();
            String text = textStripper.getText(doc);

            lines = Arrays.asList(text.split(System.lineSeparator()));
            currentLine = 0;

        }

    }
}

    // False ends the reading process
@Override
public boolean nextKeyValue() throws IOException, InterruptedException {

    if (key == null) {
        key = new Text();
    }

    if (value == null) {
        value = new Text();
    }

    if (currentLine < lines.size()) {
        String line = lines.get(currentLine);

        key.set(line);

        value.set("");
        currentLine++;

        return true;
    } else {

        // All lines are read? -> end
        key = null;
        value = null;
        return false;
    }
}

@Override
public Text getCurrentKey() throws IOException, InterruptedException {
    return key;
}

@Override
public Text getCurrentValue() throws IOException, InterruptedException {
    return value;
}

@Override
public float getProgress() throws IOException, InterruptedException {
    return (100.0f / lines.size() * currentLine) / 100.0f;
}

@Override
public void close() throws IOException {

    // If done close the doc
    if (doc != null) {
        doc.close();
    }

}