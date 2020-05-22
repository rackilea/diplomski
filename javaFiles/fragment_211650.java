public void playSound(View view){
        if (null != mediaPlayer) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        switch(view.getId())
        {
            case R.id.button1:
                mediaPlayer = MediaPlayer.create(this, R.raw.doyouspeakenglish);
                break;
            case R.id.button2:
                mediaPlayer = MediaPlayer.create(this, R.raw.goodevening);
                break;
            case R.id.button3:
                mediaPlayer = MediaPlayer.create(this, R.raw.hello);
                break;
            case R.id.button4:
                mediaPlayer = MediaPlayer.create(this, R.raw.howareyou);
                break;
            case R.id.button5:
                mediaPlayer = MediaPlayer.create(this, R.raw.ilivein);
                break;
            case R.id.button6:
                mediaPlayer = MediaPlayer.create(this, R.raw.mynameis);
                break;
            case R.id.button7:
                mediaPlayer = MediaPlayer.create(this, R.raw.please);
                break;
            case R.id.button8:
                mediaPlayer = MediaPlayer.create(this, R.raw.welcome);
                break;
            default:
                throw new RuntimeException("Unknown button ID");
        }
        i++;
    Log.i("klik", Integer.toString(i));
        mediaPlayer.start();
}