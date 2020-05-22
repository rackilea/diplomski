@Override
protected void onStop() {
    if (debug_mode) Log.d(TAG, "onStop");
    if (m_audio_player.isPlaying()) {
        m_audio_player.stop();
    }
    m_audio_player.release();
    m_handler_seek_bar.removeCallbacks(m_seek_bar_runnable);
    super.onStop();
}