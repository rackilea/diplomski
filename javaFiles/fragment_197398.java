public class Square {

    int heightInLines = 5;

    void printLine(int x){
        if(x == 1 || x == heightInLines){
            for(int i = 1; i <= 9; i ++){
                if(i == 1 || i == 5 || i == 9) System.out.print("+");
                else System.out.print("-");
            }
            System.out.println();
        }else if(x % 2 == 0) System.out.println("|       |");
        else System.out.println("+       +");

    }

    void print(){
        for(int i = 1; i <= heightInLines; i++)
            printLine(i);
    }

    public static void main(String[] args) {
        new Square().print();

    }
}