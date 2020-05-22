public static void main(String[] args) {
            String s = "| || |  ||||  |||| || || | ||| || ||";

            int[] num = {0, 1, 2, 4, 7};
            String[] parts = s.split("(?<=\\G.{6})");
            for(int i=0; i<parts.length; i++) {
              parts[i] = parts[i].substring(0, 5);
              int result = 0;
              for(int j = 0; j < num.length; j++) {
                  if(parts[i].charAt(j) == ' ') {
                      result += num[j];

                  }                   
              }
              System.out.println(result);
       }
}