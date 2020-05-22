public class SeparateClass {
    public static void randomizareImagini(Context context){

        int[] rndInt = new int[20];
        int[] id= new int[20];
        String[] imgName = new String[20];
        Random rand = new Random();
        int[] ar1 = new int[20];

        for (int i=1; i<16;i++){
            ar1[i] = rand.nextInt(3) + 1;
            rndInt[i]=ar1[i];
            imgName[i]="img"+rndInt[i];
            id[i] = context.getResources().getIdentifier(imgName[i], "drawable", context.getPackageName());
        }

        for (int i=0;i<15;i++){
            MainActivity.list.get(i).setImageResource(id[i+1]);}

    }
}