List<List<JButton>> lists = new ArrayList<List<JButton>>();
// populate (replace with your code)
lists.add(Arrays.asList(new JButton("list 1, button 1"), new JButton("list 1, button 2")));
lists.add(Arrays.asList(new JButton("list 2, button 3"), new JButton("list 2, button 4")));
lists.add(Arrays.asList(new JButton("list 3, button 5"), new JButton("list 3, button 6")));
lists.add(Arrays.asList(new JButton("list 4, button 7"), new JButton("list 4, button 8")));

// iterate
for(List<JButton> subList : lists) {
    for(JButton button : subList) {
        System.out.println(button.getText());
    }
}