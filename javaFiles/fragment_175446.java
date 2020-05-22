int jump;
String direction;
Jump[] jumpArray = new Jump[100];
int storeJump;
String storeDirection;

public void jumping() {
    jump++;
    if (jump > 50) {
        System.out.println("need a rest");
        return;
    } else {
        jumpArray[jump] = new Jump();
    }
    jumpArray[jump].storeJump = jump;
    jumpArray[jump].storeDirection = direction;

}

public static void main(String[] args) {
    Jump jumper = new Jump();
    jumper.jumping();
    jumper.jumping();

    Set<Jump> mySet = new HashSet<Jump>(Arrays.asList(jumper.jumpArray));

    for (int i = 1; i < mySet.size(); i++) {
        System.out.println(jumper.jumpArray[i].storeJump);
    }
}