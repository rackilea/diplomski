int wordEnd = 0, wordStart = 0;




Highlighter hilite = textComp.getHighlighter();
                        Document doc = textComp.getDocument();
                        String text = doc.getText(0, doc.getLength());

                        while (text.length() > wordEnd) 
                        {
                            String word = new String();
                            if(text.charAt(wordEnd) == ' ')
                            {
                                word = text.substring(wordStart, wordEnd);
                                for (int i = 0; i < pattern.length; i++) 
                                {
                                        if (word.toString().equals(pattern[i])) 
                                        {
                                            hilite.addHighlight(wordStart, (wordEnd), myHighlighter);

                                            break;
                                        }
                                }
                                wordStart = wordEnd + 1;
                            }
                            wordEnd++;
                        }