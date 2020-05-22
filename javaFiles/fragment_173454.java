InputStream is = null;
XMLStreamReader reader = null;
try {
    is = new FileInputStream(new File("/my/path/stuff.xml"));
    XMLInputFactory xif = XMLInputFactory.newInstance();
    reader = xif.createXMLStreamReader(is);
    ArrayDeque<String> nodes = new ArrayDeque<String>();
    while (reader.hasNext()) {
        int current = reader.next();
        switch (current) {
            case XMLStreamConstants.START_ELEMENT: {
                nodes.add(reader.getLocalName());
                System.out.println("START: " + nodes.getLast());
                if (nodes.size() > 1) {
                    Iterator<String> iterator = nodes.descendingIterator();
                    // skipping first one as it's already represented
                    iterator.next();
                    while (iterator.hasNext()) {
                        System.out.println("\t in " + iterator.next());
                    }
                }
                break;
            }
            case XMLStreamConstants.END_ELEMENT: {
                System.out.println("END: " + nodes.removeLast());
                Iterator<String> iterator = nodes.descendingIterator();
                while (iterator.hasNext()) {
                    System.out.println("\t in " + iterator.next());
                }
                break;
            }
        }
    }

}
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch (XMLStreamException xse) {
            xse.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                    is.close();
                }
                catch (XMLStreamException xse) {
                    xse.printStackTrace();
                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }