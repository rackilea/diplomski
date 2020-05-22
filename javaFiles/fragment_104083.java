public static void main(String[] args) 
{     
    for (String w : "camelValue".split("(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!^)(?=[A-Z][a-z])")) {
         System.out.println(w);
    } 
}