@Override
public void onClick(View v) {
    a[position] = a[position] + 1;
    value1.setText(String.valueOf(a[position]));
    Toast.makeText(context, String.valueOf(a[position]), 1000).show();
    System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
    System.out.println(a[position]);
    notifyDataSetChanged();
}