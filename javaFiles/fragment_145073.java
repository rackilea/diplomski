List<Interaction.Prompt> prompts = new ArrayList<Interaction.Prompt>();

Interaction.Prompt spanishPrompt = new Interaction.Prompt(new SpeechSynthesis("Holá."));
spanishPrompt.setLanguage("es-ES");
prompts.add(spanishPrompt);

Interaction.Prompt frenchPrompt = new Interaction.Prompt(new SpeechSynthesis("Bonjour."));
frenchPrompt.setLanguage("fr-CA");
prompts.add(frenchPrompt);

SpeechRecognition speechRecognition = new SpeechRecognition(new GrammarReference("grammar.grxml"));

FinalRecognitionWindow finalRecognitionWindow = new FinalRecognitionWindow(speechRecognition,
                                                                           Duration.seconds(2));
Interaction interaction2 = new Interaction("multilingual-interaction2",
                                           prompts,
                                           finalRecognitionWindow);

DialogueUtils.doTurn(interaction2, context);