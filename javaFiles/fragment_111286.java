String str = "mR. jOhn smIth";
final String[] arr = TextUtils.split(str," ");
final int len = arr.length;

for(int i = 0; i < len; i++)
{
    final String s = arr[i];
    final String s0 = "" + s.toUpperCase().charAt(0);
    final String s1 =  s.toLowerCase().substring(1, s.length());
    arr[i] = s0 + s1;
}

str = TextUtils.join(" ", arr); // and now str contains "Mr. John Smith"