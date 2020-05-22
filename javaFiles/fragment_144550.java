public class Main {


    public static void main(String[] args) {
        ;
        String input ="name,number,address(line1,test(city)),status,contact(id,phone(number,type),email(id),type),closedate";
        List<String> list = new ArrayList<String>(Arrays.asList(input.split(","))); // We need a list for the iterator (or ArrayIterator)
        List<String> result = new Main().parse(list);
        System.out.println(String.join(",", result));
    }

    private List<String> parse(List<String> inputString){
        Iterator<String> it = inputString.iterator();
        ArrayList<String> result = new ArrayList<>();
        while(it.hasNext()){
            String word = it.next();
            if(! word.contains("(")){
                result.add(word);
            } else { // if we come across a "(", start the recursion and parse it till we find the matching ")"
                result.addAll(buildDistributedString(it, word,""));
            }
        }

        return result;
    }

    /*
    * recursivly parse the string
     * @param startword The first word of it (containing the new prefix, the ( and the first word of this prefic
     * @param prefix Concatenation of previous prefixes in the recursion
     */
    private List<String> buildDistributedString(Iterator<String> it, String startword,String prefix){

        ArrayList<String> result = new ArrayList<>();
        String[] splitted = startword.split("\\(");
        prefix += splitted[0]+".";

        if(splitted[1].contains(")")){ //if the '(' is immediately matches, return only this one item
            result.add(prefix+splitted[1].substring(0,splitted[1].length()-1));
            return result;
        } else {
            result.add(prefix+splitted[1]);
        }

        while(it.hasNext()){
            String word = it.next();
            if( word.contains("(")){ // go deeper in the recursion
                List<String> stringList = buildDistributedString(it, word, prefix);
                if(stringList.get(stringList.size()-1).contains(")")){
                    // if multiple ")"'s were found in the same word, go up multiple recursion levels
                    String lastString = stringList.remove(stringList.size()-1);
                    stringList.add(lastString.substring(0,lastString.length() -1));
                    result.addAll(stringList);
                    break;
                }
                result.addAll(stringList);
            } else if(word.contains(")")) { // end this recursion level
                result.add(prefix + word.substring(0,word.length()-1)); // ")" is always the last char
                break;
            } else {
                result.add(prefix+word);
            }
        }
        return result;
    }
}