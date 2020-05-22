private void saveAs(final Intent intent) {
    AlertDialog.Builder alert = new AlertDialog.Builder(this);

    alert.setTitle("Save as");
    alert.setMessage("(Will be saved in the current working directory)");

    // Set an EditText view to get user input
    final EditText input = new EditText(this);
    input.setText(ending);
    alert.setView(input);

    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
            String value = input.getText().toString();
            String tmpText = et.getText().toString();
            if (!value.contains(".")) {
                value = value + ending;
            }

            try {
                File tempfile = new File(currentDirectory, value);
                FileWriter writer = new FileWriter(tempfile);
                writer.write(tmpText);
                writer.flush();
                writer.close();
                changed = false;
                exists = true;
                String newFile = new File(currentDirectory + "//" + value)
                        .getPath();
                currentFile = new File(newFile);
                fill(currentDirectory.listFiles());
                Log.i("saveAs", currentFile.getPath());
                return;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    });