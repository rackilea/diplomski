String file_name="free.txt";
File file_input = new File(file_name);
if (!file_input.exists())
    abort("FileInput: no such source file: " + file_name);
if (!_file_input.isFile())
    abort("FileInput: can't open a directory: " + file_name);
if (!file_input.canRead())
    abort("FileInput: source file is unreadable: " + file_name);