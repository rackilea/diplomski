for (HighlightEntry<YOUR_ENTITY_CLASS> he : listSolrPage.getHighlighted()) {
            for (Highlight highlight : he.getHighlights()) {
                    // Each highlight might have multiple occurrences within the description
                    StringBuilder sb = new StringBuilder();
                    for (String snipplet : highlight.getSnipplets()) {                      
                        // snipplet contains the highlighted text
                        slf4jLogger.debug(snipplet);
                        sb.append(snipplet + "");
                    }
            }
        }