Interaction interaction = OutputTurns.interaction("multilingual-interaction")
        .setLanguage("es-ES")
        .addPrompt(new SpeechSynthesis("Holá."))
        .setLanguage("fr-CA")
        .addPrompt(new SpeechSynthesis("Bonjour."))
        .build(new SpeechRecognition(new GrammarReference("grammar.grxml")),
               Duration.seconds(2));

DialogueUtils.doTurn(interaction, context);