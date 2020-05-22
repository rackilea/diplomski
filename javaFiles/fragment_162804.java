if (index > 0) { // error checking
    // Swap the given index with the previous index.
    // (where `list` is the name of your list variable)
    Collections.swap(list, index, index - 1);
}
// Finally, notify the `JList` that the list structure has changed.
fireContentsChanged(this, index - 1, index);