public static void editFile(ArrayList<String> formalLines){
        //appendText() --> insert content ---> prependText() --> return arrayList to write to file
        ArrayList<String> newList = new ArrayList<String>();
        try {
            for(String item:readLines()){
                newList.addAll(appendText());
                newList.add(item);
                newList.addAll(prependText());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static ArrayList<String> appendText () {

        ArrayList<String> append = new ArrayList<String>();
        append.add("<div id=\"page-content-wrapper\">");
        append.add("  <div class=\"container-fluid\">");
        append.add("    <div class=\"col-xs-6 col-md-4\">");
        return append;
    }

    public static ArrayList<String> prependText(){
        ArrayList<String> prepend = new ArrayList<String>();
        prepend.add("    </div>");
        prepend.add("  </div>");
        prepend.add("</div>");
        return prepend;

    }