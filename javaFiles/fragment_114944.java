public static void main(String[] args) {
        String externalFormat="Nvl(cost,Sum(Cost1)";
        String functions=externalFormat.replaceAll("\\w+\\(|\\)", "");
        System.out.println(functions.toLowerCase());

    }