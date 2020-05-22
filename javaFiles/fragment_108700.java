@Test
public void split2() {
    String input = "1_3_5_1,1_3_7_1,1_4_9_1";
    String[] csv = input.split(",");
    for(String v : csv) {
        String[] usv = v.split("_");
        System.out.print("[");
        for(int i = 0; i < usv.length; i++) {
            System.out.print(usv[i]);
            if(i < usv.length-1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}