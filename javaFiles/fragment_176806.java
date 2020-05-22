StringBuilder builder = new StringBuilder() ;
        builder.append("<html><table border=1><tr><td>Item Name</td><td>Item Price</td><td>Item Code</td></tr>");
        for( Item item_ : itemList ) {
            builder.append("<tr><td>");
            builder.append(item_.getItemName());
            builder.append("</td><td>");
            builder.append(item_.getItemPrice());
            builder.append("</td><td>");
            builder.append(item_.getItemID());
            builder.append("</td></tr>");
        }
        builder.append("</table></html>");
        JOptionPane.showMessageDialog(parentDialog,
                builder.toString());