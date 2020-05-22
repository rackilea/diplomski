List<String> nums = new ArrayList<>();
Scanner sc = new Scanner(yourText);
sc.useDelimiter("\\D+");
while(sc.hasNext()){
    nums.add(sc.next());
}