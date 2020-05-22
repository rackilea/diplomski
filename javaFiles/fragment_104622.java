public static void main(String args[]) {
    String exampleStr[][] = new String[][]
            {
                    {null,null,null},
                    // creates a 1-d String[], -> {"a", "b", "c"} is enough
                    new String[] {"a","b","c"},
                    // creates an array containing an empty string, -> {""} would be equivalent
                    {new String()} 

            };

    String exampleStr3[] = {null};

    String value = exampleStr[0][0];

    System.out.println(exampleStr.length);

    System.out.println(value);
}