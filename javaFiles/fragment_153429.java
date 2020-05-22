public class MemStorage {
    private float storedNum1;
    private float storedNum2;

    public MemStorage(float num1, float num2){
        this.storedNum1 = num1;
        this.storedNum2 = num2;
    }

    public void setNum1(float num1){
        this.storedNum1 = num1;
        System.out.println("Number 1 has been stored.");
    }

    public void setNum2(float num2){
        this.storedNum2 = num2;
        System.out.println("Number 2 has been stored.");
    }

    public float getNum1(){
        return this.storedNum1;
    }

    public float getNum2(){
        return this.storedNum2;
    }

    // Hand Test
    public static void main(String[] args){
        MemStorage memStorage = new MemStorage(0,0);
        memStorage.setNum1(1.23454f);
        System.out.println(memStorage.getNum1());
    }
}