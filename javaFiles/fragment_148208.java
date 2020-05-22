String input = "subex is in bangalore";
    StringBuilder result = new StringBuilder(input.replace(" ", "")).reverse();
    int index = input.indexOf(" ");
    while (index >= 0) {
        result.replace(index, index, " ");
        index = input.indexOf(" ", index + 1);          
    }