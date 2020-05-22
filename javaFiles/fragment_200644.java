InputStream in =getResources().openRawResource("user_mp3");      
AudioTrack audio = new AudioTrack(AudioManager.STREAM_MUSIC, 11025, AudioFormat.CHANNEL_CONFIGURATION_MONO, AudioFormat.ENCODING_PCM_16BIT, buffersize, AudioTrack.MODE_STREAM);

byte[] sound = null;
sound = new byte[in.available()]; 
sound =convertStreamToByteArray(in);
in.close();
audio.write(sound, 0, sound.length());
audio.play();