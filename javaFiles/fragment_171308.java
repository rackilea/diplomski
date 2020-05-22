table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String str = value.toString();
        String regex = ".*?user=\".*?\".*?";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        if(matcher.matches()){
            regex = "user=\".*?\"";
            matcher = Pattern.compile(regex).matcher(str);
            while(matcher.find()){
                String aux = matcher.group();
                str = str.replace(aux, "<b>" + aux + "</b>");
            }
            str = "<html>" + str + "</html>";

            setText(str);
        }                
        return this;                
    }            
});