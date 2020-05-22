public JList createJList(ResultSet rs){

        DefaultListModel model = new DefaultListModel();

        while (rs.next()){
            String author = rs.getString("author");   // Just an example. You may
            String text = rs.getString("text");       // need to retrieve your
            String date = rs.getString("date");       // data differently
            String tag = rs.getString("tag");

            Message message = new Message(author, text, date, tag);
            model.addElement(message);
        }

        JList list = new JList(model);

        return list; 
    }