for (Entry<String, ?> entry : pref.getAll().entrySet()) {
                    List<NewsItem> rowItems = new ArrayList<NewsItem>();
                    // the string from the preferences as it was saved
                    String prefContent = (String) entry.getValue();
                    // break against possible multiple NewsItems(I'm assuming that's 
                    // why you use a List of NewsItems) for the same
                    // key (every NewsItem starts with * so we split after
                    // that(see the NewsItems.toString method))
                    String[] newsItems = prefContent.split("\\*");
                    for (String item : newsItems) {
                        // an item which doesn't have at least 50 characters
                        // isn't a valid NewsItem string representation(based on
                        // its toString() method)
                        if (item.length() > 50) {
                            // ; is the delimiter for the NewsItem's data
                            String[] components = item.split(";");
                            NewsItem ni = new NewsItem();
                            // for each of the four data components we split
                            // after = and then use the second value obtained as
                            // that will be the value for that component
                            ni.setHeadline((components[0].split("="))[1]);
                            ni.setSpeed((components[1].split("="))[1]);
                            ni.setDirection((components[2].split("="))[1]);
                            ni.setDate((components[3].split("="))[1]);
                            rowItems.add(ni);
                        }
                    }
                    listDataChild.put(entry.getKey(), rowItems);
                }