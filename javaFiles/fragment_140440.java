public class Test10 {

    public static void main(String[] args) {
        String example[] = new String[5];
        example[0] = "a";
        example[1] = null; 
        example[2] = "c"; 
        example[3] = "d"; 
        example[4] = "e";

        for (int j=0; j<example.length; j++){
            if (example[j]==null){
                for (int k=j+1; k<example.length; k++){
                    example[k-1] = example[k];
                }
                example[example.length-1] = null;
                break;
            }
        }

        for (int j=0; j<example.length; j++){
            System.out.println(example[j]);
        }
    }

}