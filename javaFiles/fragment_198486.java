public static void main(String[] args) {

    JPanel help_area_container = new JPanel();

    help_area_container.setBorder(BorderFactory.createLineBorder(
            Color.BLUE, 3));
    help_area_container.setLayout(new GridLayout(4, 0));

//Should have set sizes below
    JPanel voting_container = new JPanel();
//voting_container.setSize(50,50);
    JPanel calling_container = new JPanel();
    JPanel half_container = new JPanel();
    JPanel take_container = new JPanel();
    JPanel[] all_help_container = new JPanel[] { voting_container,
            calling_container, half_container, take_container };
    for (int i = 0; i < all_help_container.length; i++) {
        all_help_container[i].setBorder(BorderFactory
                .createLineBorder(Color.RED));
        all_help_container[i].setPreferredSize(new Dimension(350,
                help_area_container.getPreferredSize().height / 4));
    }

    for (int i = 0; i < all_help_container.length; i++) {

        System.out.println(all_help_container[i].getSize());

    }

}

// where you can change the size
    all_help_container[0].setSize(50, 50);

    System.out.println("----");

    for (int i = 0; i < all_help_container.length; i++) {

        System.out.println(all_help_container[i].getSize());

    }
}