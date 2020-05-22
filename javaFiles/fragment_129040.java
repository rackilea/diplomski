@Click(R.id.buttonExport)
void buttonExportClicked(View view) {
    FileOutputStream fileOutputStream;
    try {
        if (!headerFinished || !footerFinished || !contentFinished) {
            compileHeader();
            compileContent();
            compileFooter();
        }
        summaryTableLayout.post(new Runnable(){
           @Override
           public void run() {
               // code to generate pdf
           }

        })

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}