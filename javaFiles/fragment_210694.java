String pattern="^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

    String input="VIII";
    if(input.matches(pattern)){
        System.out.println("true");
    }else{
        System.out.println("false");
    }