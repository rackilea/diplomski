public void afterTextChanged(Editable editable) {
    String string = editable.toString();
    String[] split = string.split("\\s");

    int startIndex = 0;
    for(int i = 0 ; i < split.length ; i++){
        String s = split[i];
        if(map.containsKey(s)){

            int index = string.indexOf(s, startIndex);
            int color = map.get(s);
            editable.setSpan(new ForegroundColorSpan(color),
                    index,
                    index + s.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            startIndex = index + s.length();
        }

    }
}