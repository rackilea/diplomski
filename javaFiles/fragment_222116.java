public class Solution {
int mRow;
int nColumn;

Scanner input = new Scanner(System.in);
int a[][] ;
void getInput() {
    System.out.println("Enter number of rows:");
    mRow = input.nextInt();
    System.out.println("Enter number of columns:");
    nColumn = input.nextInt();
    a = new int[mRow][nColumn];
}



void getElement() {
    System.out.println("Enter the elements of the matrix: ");
    for (int i = 0; i < mRow; i++) {
        for (int j = 0; j < nColumn; j++) {
            int value = input.nextInt();
            a[i][j] = value;
        }
    }
}

void showMatrix() {
    for (int i = 0; i < mRow; i++) {
        for (int j = 0; j < nColumn; j++) {
            System.out.print(a[i][j] + " ");
        }
      System.out.println();
  }
  }

public static void main(String[] args){
    Solution solution = new Solution();
    solution.getInput();
    solution.getElement();
    solution.showMatrix();
}
}