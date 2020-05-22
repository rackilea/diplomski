String str="first, second";
String[] arr=str.split(",");
if(arr.length == 2) {
    System.out.println("First :" + arr[0]);
    System.out.println("Second :" + arr[1]);
} if(arr.length > 2) {
    System.out.println("More than 1 comma used.");
} else {
    System.out.println("Error. No comma found.");
}