Scanner sc = new Scanner(System.in);
int times = 0;

if ( sc.hasNext() ) {   // check to make sure there's valid input first
    times = sc.nextInt();


    String stones[] = new String[times];
    int score = 0;
        int counter;

    for(int tcase = 0; tcase < times; tcase++)
        stones[tcase] = br.readLine();

    if ( stones[0] != null ) {  // check to make sure your array object exists
        int s = stones[0].length();
        for (int i = 0; i < s ; i++) {
            char j = stones[0].charAt(i);
            counter = 0;
            for (int k = 1; k < times; k++) {
                char aa[] = stones[k].toCharArray();
                for (int l = 0; l <aa.length ; l++) {
                    if(aa[l]==j)
                    {
                        counter++;
                        break;
                    }
                }
                if (counter==times-1) {
                    score++;
                }
            }
        }
    }
}