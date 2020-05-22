long insertedId = audioFileDao.insertAudioFile(audioFile);
if (insertedId > 0) {
    audioFile.setId(insertedId);
} else {
    //......... handle not inserted
}