if (arguments[0].contains(":")) { // If the first argument contains colons
    String[] parts = arguments[0].split(":"); // Split the string at all colon characters
    int typeId; // The type ID
    try {
        typeId = Integer.parseInt(parts[0]); // Parse from the first string part
    } catch (NumberFormatException nfe) { // If the string is not an integer
        sender.sendMessage("The type ID has to be a number!"); // Tell the CommandSender
        return false;
    }
    byte data; // The data value
    try {
        data = Byte.parseByte(parts[1]); // Parse from the second string part
    } catch (NumberFormatException nfe) {
        sender.sendMessage("The data value has to be a byte!");
        return false;
    }

    Material material = Material.getMaterial(typeId); // Material will be null if the typeId is invalid!

    // Get the block whose type ID and data value you want to change

    if (material != null) {
        block.setType(material);
        block.setData(data); // Deprecated method
    } else {
        sender.sendMessage("Invalid material ID!");
    }

}