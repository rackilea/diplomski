public static void replace(String s) {
    for (int i = 1; i <= 1000; i++) {
        Date documentsDate = Calendar.getInstance().getTime();
        SimpleDateFormat documentDates = new SimpleDateFormat("ddMMyy");
        String setTitleDocument = documentDates.format(documentsDate);
        String countDocument = String.format("%04d", i);
        textNameDocument.setText("Document " + setTitleDocument + countDocument);
    }
}