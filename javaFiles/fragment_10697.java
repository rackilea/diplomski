String backupDBPath = sd + "/com.AH.memorisethai/Backup/database.db";
File backupDirectory = new File(backupDBPath);
backupDirectory.mkdirs();

String backupFilePath = backupDBPath + "/" + "Text.txt";
File backupFile = new File(backupFilePath);

FileOutputStream outStream = new FileOutputStream(backupFile);