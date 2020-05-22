@Override
public void onStopTrackingTouch(SeekBar seekBar) {

    //Just call to fetch content with progressValue and update adapter inside onChanged
    viewModel.getAllThings(progressValue);
}