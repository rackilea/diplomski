public class Foo {
    public static void main(String[] args) {
        // Your main method code goes here
    }

    public char[] methodA() {
        char[] alphas = {'s', 't', 'e', 'a', 'm'};
        char temp = alphas[0];
        int i = 0;

        while (i < alphas.length - 1)//1
        {
            alphas[i] = alphas[i+1]; //2
            i++;
        }

        alphas[alphas.length-1]=temp;
        return alphas;
    }
}