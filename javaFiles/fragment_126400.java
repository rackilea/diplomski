private static boolean findTag(XMLTree xml, String tag,boolean result) {       
    if (xml.isTag() && !result) {
        for (int i = 0; i < xml.numberOfChildren(); i++) {

            findTag(xml.child(i), tag,result);
            System.out.println("label is " + xml.label());
            if (xml.label().equals(tag)) {
                result = true;
                System.out.println(result);
                return result;
            }
        }
    }

    return result;
}