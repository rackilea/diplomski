instanceGrid.addColumn(instance -> getTagName(instance));
   public static String getTagName(Instance instance) {
        if (instance.getTags() != null) {
            for (Tag tag : instance.getTags()) {
                if (tag.getKey().equals("Name")) {
                    return tag.getValue();
                }
            }
        }
        return "";
    }