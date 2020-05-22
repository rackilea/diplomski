List<String> list2 =new ArrayList<String>();
int iArr[] = new int[ja.length()];//{"846001","846005","846000","846002","846009"}

for (int i = 0; i < ja.length(); i++) {
    _jobject = ja.getJSONObject(i);
    iArr[i] = Integer.parseInt(_jobject.getString("Pincode"));
}
Arrays.sort(iArr);
for(int k=0;k<iArr.length;k++) {
    list2.add(String.valueOf(iArr[k]));
}