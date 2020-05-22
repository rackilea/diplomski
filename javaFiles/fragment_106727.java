public class CopyMachine {

    public static int totalNoOfCopy;

    public String[] copy(String strText, int intNos) {
        String[] ac= new String[intNos];
        for (int i=0; i< intNos; i++) {
            ac[i] = strText;
        }
        totalNoOfCopy += intNos;
        return ac;
    }

    public static void main(String[] args) {
        CopyMachine canon = new CopyMachine();
        String[] canonCopys = canon.copy("Flying!", 6);
        CopyMachine fujitsu = new CopyMachine();
        String[] fujitsuCopys = fujitsu.copy("High!", 8);

        System.out.println("Copies from Canon");
        for(String str: canonCopys) {
            System.out.println(str);
        }

        System.out.println("Copies from fujitsu");
        for(String str: fujitsuCopys) {
            System.out.println(str);
        }

        System.out.println("Total copies:" + CopyMachine.totalNoOfCopy);
    }
}