public class MyPage implements DialogBoxOpener {
    private MyDialogBox myDialogBox = getMyDialogBox();

    private void openDialogBox () {
            myDialogBox.showDialogBox(this);
    }

    public void dialogBoxValidated (Date selectedDate) {
            // TODO : Do something with the date
    }

    public void  dialogBoxCancelled () {
            // TODO : Do something
    }
}