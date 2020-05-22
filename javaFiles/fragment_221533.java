private void logAudioFile(AudioFile a, String extra) {
    Log.d(
            "AUDIOFILEINFO",
            "Title is " + a.getTitle() +
                    " ID is " + a.getId() +
                    "\n\tExtra Info is " + extra
    );
}