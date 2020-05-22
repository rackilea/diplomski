@Test
public void testonBindView() {
    songAdapterPresenter.setSongs(songList);
    songAdapterPresenter.onBindView(songView, 0);
    verify(songView).showSelectionUi(true);
}