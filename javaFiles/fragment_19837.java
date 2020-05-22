public class TestArgu {

        public TestArgu()
        {
            ansNumber = 0;
            chk       = 0;
        }  

        public void addNumber(int aNumber){
            ansNumber = aNumber+5;
            chk = aNumber;
            System.out.println("input number = " + chk + ".\n");
            System.out.println("ans = " + ansNumber + ".\n");
        }

        public int ansChk(){
            return ansNumber;
        }

        private int ansNumber;
        private int chk;
 }