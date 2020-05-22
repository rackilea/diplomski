public void search() {
    // join text of all selected JCheckBoxes from checkBoxes array
    String conditions = Arrays.stream(checkBoxes) // create a stream of language checkboxes
            .filter(JCheckBox::isSelected) // restrict stream to selected checkboxes
            .map(JCheckBox::getText) // convert from checkbox to query string
            .collect(Collectors.joining("' or language like '")); // join query strings using a delimiter

    ...

    if (!conditions.isEmpty()) {
        // at least one language selected
        ...

        String query = "select language from language where language like '"+ conditions+"'  ;";

        ...    
    }

    ...
}