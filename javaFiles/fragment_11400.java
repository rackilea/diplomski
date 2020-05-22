boolean result = mainEmail.trim().contentEquals(deletionemailAddress.trim());
int count = 0;
if (result){
    count++;
    System.out.println(mainEmail);
    System.out.println(deletionemailAddress);
    System.out.println(result);
}
System.out.println(count);