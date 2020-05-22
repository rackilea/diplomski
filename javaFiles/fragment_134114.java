KeyCombination ctrlC = new KeyCodeCombination(KeyCode.C, KeyCombination.SHORTCUT_DOWN);
    final EventStream<KeyEvent> keysTyped = EventStreams.eventsOf(text, KeyEvent.KEY_PRESSED)
            // the following line, if uncommented, will limit the frequency
            // of processing ctrl-C to not more than once every 0.5 seconds
            // As a side-effect, processing will be delayed by the same amount
            // .reduceSuccessions((a, b) -> b, Duration.ofMillis(500))
            .filter(ctrlC::match);
    keysTyped.subscribe(event -> System.out.println("Ctrl-C pressed!"));