ArrayList<Element> element = new ArrayList<Element> ();
        Element element1 = new Element("a", "1");
        Element element2 = new Element("b", "2");
        Element element3 = new Element("b", "2");
        element.add(element1);
        element.add(element2);
        if(element.contains(element3)){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }