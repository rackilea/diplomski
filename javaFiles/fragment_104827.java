class BtnListener implements ActionListener {
    Map<Object, Consumer<ActionEvent>> eventsMap = new HashMap<>();

    public BtnListener() {
        eventsMap.put(menu.getOpen(), actionEvent -> this.getFile());
        eventsMap.put(btnPlay, actionEvent -> { //do something
        });
        eventsMap.put(btnQuit, actionEvent -> { //do something else
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Optional.of(e)
                .map(ActionEvent::getSource)
                .map(eventsMap::get)
                .ifPresent(
                        actionEventConsumer -> actionEventConsumer.accept(e)
                );
    }
}