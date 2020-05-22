@Override
public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);

    //If it is an integer
    outState.putInt(TAG, mBallPosition);

    //Or use a serializable if you wish to store an actual object
   outState.putSerializable(TAG, mBallPosition);
}