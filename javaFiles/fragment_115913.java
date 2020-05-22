if (response.body().getSoftware()[i].status) {
   softwareStatus.setTextColor(Color.GREEN);
} else {
   softwareStatus.setTextColor(Color.RED);
}
softwareStatus.setText(response.body().getSoftware()[i].status.toString())
//or use softwareStatus.setText("" + response.body().getSoftware()[i].status) if status is primitive boolean and not object Boolean