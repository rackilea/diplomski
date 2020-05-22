for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element)list.item(i);                
                String item = element.getNodeName().toString();
                if (!allValues.contains(item)){
                     comboBox.addItem(item);
                     allValues.add(item);
                }
            }