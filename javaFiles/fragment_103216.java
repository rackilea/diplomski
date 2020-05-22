// working code
int char_count = 3000;
int start = 0;
int end = char_count;
HashMap<String, String> map = new HashMap<String, String>();
map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "UniqueID");
tts.speak(text.substring(start, end), TextToSpeech.QUEUE_ADD, map);

tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                        @Override
                        public void onStart(String s) {}

                        @Override
                        public void onDone(String s) {
                            start = end;
                            end+= char_count;
                            end = text.indexOf(" ", end);

                            if(end >= text.length() || end == -1){
                                end = text.length();
                            }if(start >= text.length()){
                                System.out.println("end of text");
                            }else {
                                speek();
                            }

                        }

                        @Override
                        public void onError(String s) {}
                    });