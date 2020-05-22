public ModelClass loadNext(String id) {
    ModelClass nextAudio = null;

    int pos = 1;
    for (int index = 0; index < FileList.size(); index++) {
        if (ModelClass.get(index).getFileUID().equals(id)) {
            pos = index + 1;
            break;
        }
    }

    if (pos != AudioFileList.size())
        nextAudio = AudioFileList.get(pos);

    return nextAudio;
}