private String[]  tags     = new String[] { "Mike", "Bob", "Tom", "Greg" };
private boolean[] selected = new boolean[tags.length];
public List<String> selected_tags = new ArrayList<String>();

for (int i = 0; i < tags.length; i++) {
    if (selected[i] == true){
        selected_tags.add(tags[i]);
    } 
}