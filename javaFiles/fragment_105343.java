public void CheckForSong(){
    int contains = Collections.indexOfSubList(mPlayed, mDespacito);
    if (contains != -1){
        Log.d("Xylophone","You just played despacito");
        mPlayed.removeAll(mDespacito);
    }
}