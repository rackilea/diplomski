private String getPrintingLabels(ResultSet rs) throws SQLException {
        Pattern p = Pattern.compile("([a-zA-Z]+)(,? )?");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listModelGrid.getSize(); i++) {
            String element = String.valueOf(listModelGrid.getElementAt(i));

            Matcher m = p.matcher(element);
            while(m.find()) {
                sb.append(rs.getString(m.group(1)));
                if (m.group(2) != null) {
                    sb.append(m.group(2));
                }
            }
            sb.append(System.getProperty("line.separator")); // helps correctly insert a new line for any platform linux/windows/any
        }
        System.out.println(sb.toString());
        return sb.toString();
    }