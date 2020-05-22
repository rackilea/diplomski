try {

            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File("D:\\your_file.xml");

            Document doc = (Document) builder.build(xmlFile);
            Element rootNode = doc.getRootElement();

            Element lexiconElement = rootNode.getChild("lexiconElement");

            // 1. add new <tag> elements to xml
            Element newTag = new Element("your_new_tag").setText("your_new_tag_value");
            lexiconElement.addContent(newTag);

            // 2. Update the text between <frequancy> in perticular tag
            //lexiconElement.getChild("tag").getChild("frequancy").setText("9");

            // 2. Update the text between <frequancy> in all tag
            List<Element> list = lexiconElement.getChildren("tag");
            for(Element elm : list){
                elm.getChild("frequancy").setText("324");
            }

            // 3. Update the text between <word>
            lexiconElement.getChild("word").setText("yyyy");

            XMLOutputter xmlOutput = new XMLOutputter();

            xmlOutput.output(doc, new FileWriter("D:\\your_file.xml"));

            System.out.println("*********Done************");
        } catch (IOException io) {
            io.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }