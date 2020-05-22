Scanner sc = new Scanner(System.in);
ArrayList<String> inputData = new ArrayList<String>();
while(sc.hasNext()) {
    String aStr = sc.nextLine();
    String sentinel = "0 0 0";
    if(aStr.equals(sentinel)){
        System.out.println("Failed");
        break;
    }
    else{
        inputData.add(aStr);
    }
}
System.out.println(Arrays.toString(inputData.toArray())); // for debug
sc.close();