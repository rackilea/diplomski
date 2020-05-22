public static String belrusToEngTranlit (String text){
    char[] abcCyr = {'a','б','в','г','д','ё','ж','з','и','к','л','м','н','п','р','с','т','у','ў','ф','х','ц','ш','щ','ы','э','ю','я'};
    String[] abcLat = {"a","b","v","g","d","jo","zh","z","i","k","l","m","n","p","r","s","t","u","w","f","h","ts","sh","sch","","e","ju","ja"};

    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < text.length(); i++) {
        for(int x = 0; x < abcCyr.length; x++ )
        if (text.charAt(i) == abcCyr[x]) {
            builder.append(abcLat[x]);
        }
    }
    return builder.toString();
}