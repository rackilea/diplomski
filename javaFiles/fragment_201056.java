public static void main(String[] args) {
            String s = "| || |  ||||  |||| || || | ||| || ||";

            int result = 0;
            int[] num = {0, 1, 2, 4, 7};
            String over = "";
            String[] parts = s.split("(?<=\\G.{6})");
            for(int i=0; i<parts.length; i++) {
              parts[i] = parts[i].substring(0, 5);
              over = parts[i];
              int intermediateResult = 0;
              for(int j = 0; j < num.length; j++) {
                  if(over.charAt(j) == ' ') {
                      intermediateResult += num[j];

                  }                   
              }
              result = intermediateResult;
              System.out.println(result);
       }
}