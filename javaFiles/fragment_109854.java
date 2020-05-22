Shell shell = ... current shell

FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);

fileDialog.setFilterExtensions(new String [] {"*.png", "*.*"});

fileDialog.setFilterPath(.... any default path you want ....);

String filePath = fileDialog.open();

// TODO check for null 'filePath' - user canceled the save

File file = new File(filePath);

ChartUtilities.saveChartAsPNG(file, calidad, chart, 800, 600);