int spaces = 13;
String stars = "*";
for(int i = 1;i<=4;i++){
    System.out.print("* * * * *");
    for(int j=1;j<=spaces;j++){
        System.out.print(" ");
    }
    spaces--;
    System.out.println(stars);
    stars+=" *";
}