@Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        //List<Integer> numberlist = new ArrayList<Integer>(); //you clear your list here
        int a = Integer.parseInt(txtNotation.getText());

        if (source.equals(btAddNumber)) {
            System.out.println("Number was added to list");
            numberlist.add(a);
        } else if (source.equals(btOutput)) {
            displayOutput();
        } else if (source.equals(btAddlist)) {
            System.out.println("Number of list was added to ListCollection");
            //numberlist.clear();   //you then added empty list to your collection (cause add doesn't copy it, it adds a reference to it)
            listCollection.add(numberlist);
            numberlist = new ArrayList<Integer>(); //creates new list instead of clearing old one
        }

    }