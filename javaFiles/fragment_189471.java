@Test
public void ExampleAssertProgressBar(){
    ProgressBar progressBar = activity.getActivity().findViewById(R.id.progressBar);
    int progress = progressBar.getProgress();
    assertThat(progress, equalTo(50));
}