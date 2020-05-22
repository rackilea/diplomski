ColumnConfig<Users, String> userCol = new ColumnConfig<SelectUserDialog.Users, String>(selectUserProperties.userName(), 240);

        AbstractCell<String> c2 = new AbstractCell<String>() {

            @Override public void render(com.google.gwt.cell.client.Cell.Context context, String value, SafeHtmlBuilder sb) {
                value = "<div  style=\"font-size:2.5EM; line-height : 30px; height=40px\" >" + value + "</div>";
                sb.appendHtmlConstant(value);
            }
        };

        userCol.setCell(c2);