for (Resource resource : list) {
    for (Tag resourceTag : resource.getTags()) {
        if (resourceTag.getKey().equals(tag.getKey())) {
            tagFound = true;
            break;
        }
    }
}