String input = "[[2,3],[4,5],'hello',3,[3,[5,[6,7]]]],'hi',3";
String[] splited = input.split(",");
List<String> result = new ArrayList<String>();

int brackets = 0;
String aux = "";
for (String string : splited) {
    char[] word = string.toCharArray();

    // count the brackets
    for (char c : word) {
        if(c=='['){
            brackets++;
        }
        else if(c==']'){
            brackets--;
        }
    }

    aux = aux + string;

    // if all opened brackets are closed
    if (brackets == 0) {
        result.add(aux);
        aux = "";
    } else {
        aux = aux + ",";
    }
}
// the list 'result' contains 3 elemets. Each one is one element separeted by comma