public static void main(String args[]) {
    List<String> lines = new ArrayList<String>();
    lines.add("This is first line.");
    lines.add("This is second line.");
    lines.add(" ");
    lines.add(" ");
    lines.add(" ");
    lines.add(" ");
    lines.add("This is third printed line.");
    lines.add(" ");
    lines.add("This is fourth printed line.");
    lines.add(" ");
    lines.add(" ");
    lines.add(" ");
    lines.add("#ACC004342-123");
    lines.add(" ");
    lines.add(" ");
    lines.add(" ");
    lines.add(" ");
    lines.add(" ");
    lines.add(" ");
    lines.add("More information:");
    lines.add("This is fifth printed line.");
    lines.add("#ACC004342-123");
    lines.add("");
    lines.add("This is Sixth printed line.");
    lines.add("Some information goes here.");

    //count empty lines
    int emptyLineCounter = 0; 

    for (final String line : lines) {
        //when empty line increment counter, else reset counter
        if(line.trim().length() == 0) 
            emptyLineCounter++;
        else
            emptyLineCounter = 0;

        //when more then 2 empty lines are encountered move ignore line
        if(emptyLineCounter <= 2)
            System.out.println(line); //add line to document
    }
}