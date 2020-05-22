@Override
public void OnClickVideo(Uri videoUri) {

    DoAction(videoUri.toString());

}

private void DoAction(String videoUri) {

    Toast.makeText(getApplicationContext(), videoUri, Toast.LENGTH_LONG).show();

}