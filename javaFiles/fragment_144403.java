while ((imsi = reader.readLine()) != null) {
    if (!imsi.isEmpty() && !imsi.equals("OK") && !imsi.equals("AT+CIMI") {
        txtOutput.insert(imsi);
        lblImsi.setText(imsi);
    }
}