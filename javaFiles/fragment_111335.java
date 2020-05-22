try (Scanner scanner = new Scanner(System.in)) {
    for (int i = 2; i <= 1000; i++) {
        String next = scanner.nextLine();
        if(next.equals("0")){
            return;
        }else{
            for(int j = 2;j<=i;j++){
                if(j==i){
                    System.out.println(j);
                }else if(i%j==0){//if j is divisible by i...
                    i++;         //try the next i, so we don't print a blank line
                    j=2;         //and reset j
                }
            }
        }
    }
}