@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
if (resultCode == R.drawable.v1)textView.setText("you got 01");
else if (resultCode == R.drawable.v2)textView.setText("you got 02");
else if (resultCode == R.drawable.v3)textView.setText("you got 03");
else if (resultCode == R.drawable.v4)textView.setText("you got 04");
else if (resultCode == R.drawable.v5)textView.setText("you got 05");
else if (resultCode == R.drawable.v6)textView.setText("you got 06");
else if (resultCode == R.drawable.v7)textView.setText("you got 07");
else if (resultCode == R.drawable.v8)textView.setText("you got 08");
else if (resultCode == R.drawable.v9)textView.setText("you got 09");
else if (resultCode == R.drawable.v10)textView.setText("you got 10");
}