while(input!=-1){
    int last =0;
    for (int i=0; i<input ; i++){

        int ip1=keyboard.nextInt();
        int ip2=keyboard.nextInt();

        speed = speed + ip1*(ip2-last);
        last = ip2;
    }
    output = output +speed + "miles" + "\n";
    speed =0;
 input = keyboard.nextInt();
}