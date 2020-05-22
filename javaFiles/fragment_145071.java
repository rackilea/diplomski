//Play a synthesis message in another language
Message message = new Message("synthesis-french-message",
                      new SpeechSynthesis("Ceci est un message."));

message.setLanguage("fr-CA");
DialogueUtils.doTurn(message, context);