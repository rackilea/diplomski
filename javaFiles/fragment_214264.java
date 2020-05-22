// Element is { id, children }
Dictionary<String, Element> elements;

for (JSONObject obj : arr) {
    if (elements.hasKey(obj.id)) {
        // Maybe you need to update your element or something here
    } else {
        // Create your element
        elements[obj.id] = new Element(obj.id);
    }

    // if the parent does not exist, create a shadow of the parent
    // (it'll get filled in with more info above if encountered later)
    if (!elements.hasKey(obj.parent)) {
        elements[obj.parent] = new Element(obj.parent);
    }

    // Add yourself to children
    elements[obj.parent].children.push(elements[obj.id]);
}

// TODO: iterate your dictionary and put it into an array, this should be straightforward
// Or if you want the root of your tree return elements[""]