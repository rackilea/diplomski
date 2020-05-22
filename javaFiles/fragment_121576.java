//WRITER document (odt)
    Nodes odtScriptNodes = document.query("//text:script[translate(@script:language, 'CIJOPRST', 'cijoprst')='jooscript']", XPATH_CONTEXT);
    Nodes scriptNodes = odtScriptNodes;

    //CALC document (ods)
    Nodes odsPotentialScriptNodes = document.query("//table:table-cell", XPATH_CONTEXT);
    for(int nodeIndex = 0; nodeIndex < odsPotentialScriptNodes.size(); nodeIndex++){
        Element tableCellElement = (Element) odsPotentialScriptNodes.get(nodeIndex);
        Elements textElements = tableCellElement.getChildElements();
        if(textElements.size() > 0 && textElements.get(0).getValue().toLowerCase().startsWith("--!jooscript:")){
            String fullScript = textElements.get(0).getValue().substring("--!jooscript:".length());
            for(int elementIndex = 1; elementIndex < textElements.size(); elementIndex++){
                fullScript += System.getProperty("line.separator") + textElements.get(elementIndex).getValue();
            }
            for(int elementIndex = textElements.size()-1; elementIndex > 0; elementIndex--){
                tableCellElement.removeChild(elementIndex);
            }

            Element firstTextElement = (Element) tableCellElement.getChild(0);
            firstTextElement.removeChildren();
            firstTextElement.appendChild(fullScript);
            scriptNodes.append(firstTextElement);
        }
    }