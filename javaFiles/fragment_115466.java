@Override
public void onClick(View v) {
    switch (v.getId()) {
    case R.id.btn_bes1:
        Intent a = new Intent(this, PictureFingeringChart.class);
        String strName = "image_2"; // this variable changes for each button
        a.putExtra("image_name", strName);
        startActivity(a);

        break;

    default:
        break;
    }
}