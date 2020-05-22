int sum = 0;
for(int i = 0;i<arr.length();i++){
    listdata.add(arr.get(i).toString());
    String money = arr.getJSONObject(i).getString("amount");
    sum += Integer.parseInt(money);
}
System.out.println(sum);