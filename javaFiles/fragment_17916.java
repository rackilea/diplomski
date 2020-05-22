package tests.StackOverflow;

public class Question_20773692 {

    private static int N;

    public static void main(String[] args) {

        float[][] img;
        int count;

        N=3;
        count = 0;
        img = new float[N][N];
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                img[i][j] = count++;
            }
        }

        printImg(img);

        rotateRight(img);

        printImg(img);

    }

    public static void printImg(float[][] img) {
        for(int j=0; j<N; ++j) {
            System.out.print("-");
        }
        System.out.println();
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                System.out.print((int)(img[i][j]));
            }
            System.out.println();
        }
        for(int j=0; j<N; ++j) {
            System.out.print("-");
        }
        System.out.println();   }

    public static void rotateRight(float[][] img){
        for (int i=0; i<N/2; i++){
            for (int j=i; j<N-i; j++){
            //for (int j=i+1; j<N-i; j++){ //fix
                int J_COMP = N-j-1; //complement of J
                int LEFT = i;
                int RIGHT = N-i-1;
                int TOP = i;
                int BOTTOM = N-i-1;

                float temp = img[J_COMP][LEFT];
                img[J_COMP][LEFT] = img[BOTTOM][J_COMP];
                img[BOTTOM][J_COMP] = img[j][RIGHT];
                img[j][RIGHT] = img[TOP][j];
                img[TOP][j] = temp;
            }
        }       
    }
}