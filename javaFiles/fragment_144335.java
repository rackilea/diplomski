int flag = 0;
for (int j=0;j<a.length;j++) {

        if (a.length != a[j].length){
            System.out.println("Not a Square!");
            flag = 1;
            break;
        }

}   
if (flag == 0){
    System.out.println("It is a Square");
}