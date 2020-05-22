...... database built
    mAudioFileDao = mAppDB.audioFileDao();

    AudioFile a = new AudioFile();
    a.setTitle("MySong");
    a.setDuration(5);
    a.setArtist("Fred");
    a.setPath("/thepath");

    logAudioFile(a,"Before Insert into DB");
    long currentId = mAudioFileDao.insertAudioFile(a); //<<<<<<<<<< INSERT INTO DB
    logAudioFile(a,"Immediately after Insert. ID returned from insert is " + currentId);
    a.setId(currentId); //<<<<<<<<<< SET the the id of the AudioFile object a
    logAudioFile(a,"After setting the ID to " + currentId);
    mAudioFileDao.updateAudioFile(a);
    List<AudioFile> audioFileList = mAudioFileDao.getAll();
    for (AudioFile af: audioFileList) {
        logAudioFile(af,"Extracted from DB");
    }
    mAudioFileDao.deleteAudioFile(a);
    Log.d("AUDIOFILEINFO","Attempt to delete Audio File undertaken");
    audioFileList = mAudioFileDao.getAll();
    for (AudioFile af: audioFileList) {
        logAudioFile(af,"After deletion");
    }