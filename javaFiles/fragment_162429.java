/**
 * Tests if a specified file should be included in a file list.
 *
 * @param   dir    the directory in which the file was found.
 * @param   name   the name of the file.
 * @return  true if and only if the name should be
 *          included in the file list; false otherwise.
 */
boolean accept(File dir, String name);