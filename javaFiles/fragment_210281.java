JFrame frame = new JFrame();

//Other frame "stuff"

JList list = new JList(new Object[]{"121", "131", "141", "151" , "111", "181"});
    list.setSelectionModel(new MySelectionModel(list, 5)); //<-- This is the magic line right here

    frame.setVisible(true);