public int getType(int column) {
        // Reflects the assumption that all commonly used field types (meaning everything
        // but blobs) are convertible to strings so it should be safe to   call
        // getString to retrieve them.
        return FIELD_TYPE_STRING;
    }