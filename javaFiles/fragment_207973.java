if(l.contains("search yahoo")||l.contains("yahoo search")&& !l.contains("search yahoo search"))
                {
                    String query = l;
                    query = query.replace("search", "");
                    query = query.replace("yahoo", "");
                    String url = "http://search.yahoo.com/search?p=" + query;
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                else if(l.contains("search bing")||l.contains("bing search")&& !l.contains("search bing search"))
                {
                    String query = l;
                    query = query.replace("search", "");
                    query = query.replace("bing", "");
                    String url = "http://www.bing.com/search?q=" + query + "&go=Submit&qs=ds&form=QBLH";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                else {
                    String v2txt = txt2SpeechWords.get(0);

                    v2txt = v2txt.replace("search", "");

                    txt2Speech.speak("searching " + v2txt, TextToSpeech.QUEUE_FLUSH, null);

                    Intent search = new Intent(Intent.ACTION_WEB_SEARCH);
                    search.putExtra(SearchManager.QUERY, v2txt);
                    startActivity(search);
                }