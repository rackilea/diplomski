if (!item.isFormField()) {
    if ("image".equals(item.getFieldName())) {
        if (item.getName() == null || item.getName().isEmpty()) {
            // No file was been selected.
        }

        if (item.getSize() == 0) {
            // No file was been selected, or it was an empty file.
        }
    }
}