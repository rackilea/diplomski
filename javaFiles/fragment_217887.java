If you need to get first letter of all words capital ..
-----------------------------------------------------



 public String toTheUpperCase(String givenString) {
            String[] arr = givenString.split(" ");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < arr.length; i++) {
                sb.append(Character.toUpperCase(arr[i].charAt(0)))
                        .append(arr[i].substring(1)).append(" ");
            }
            return sb.toString().trim();
        }



When you need first letter of first word to be capitalized 
-------------------------------------------------------------


public String toTheUpperCaseSingle(String givenString) {
                String example = givenString;

                example = example.substring(0, 1).toUpperCase()
                        + example.substring(1, example.length());

                System.out.println(example);
                return example;
            }