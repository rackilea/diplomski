Elements elements = doc.select("menu#EE18_ViewSelectorMenu");
                Elements menuelements =elements.get(0).children();
                for (int i = 0; i < menuelements.size(); i++) {
                    String required = menuelements.get(i)
                            .attr("onMenuClick");
                }