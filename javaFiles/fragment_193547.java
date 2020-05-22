container.add(panelSize);
container.add(Box.createHorizontalStrut(40));
container.add(panelToppings);
container.add(Box.createHorizontalStrut(40));
container.add(panelDrinks);
container.add(calculateTotal);


JPanel panel = new JPanel(new BorderLayout());
panel.setBorder(BorderFactory.createEmptyBorder(10, 200, 10, 700));
panel.add(order, BorderLayout.EAST);
container.add(panel);