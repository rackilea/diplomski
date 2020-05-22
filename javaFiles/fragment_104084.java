public static void main(String[] args) 
{     
    for (String w : "camelValue".split("(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])")) {
         System.out.println(w);
    } 
}