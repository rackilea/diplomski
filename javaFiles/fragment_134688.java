final File folder = new File(System.getProperty("user.home"), "gamesaves");
if(!folder.exists() && !folder.mkDirs()) {
   //failed to create the folder, probably exit
   throw new RuntimeException("Failed to create save directory.");
}
final File myFile = new File(folder, vNomFichier + ".txt");
final PrintWriter pw = new PrintWriter(myFile);