@Override
public int getItemViewType(int position) {
    if (itemList.get(position) instanceof SectionHeader) {
        return TYPE_SECTION_HEADER;
    }
    /* return TYPE_SECTION_HEADER if the data in the list is an instance of 
       SectionHeader and other corresponding types as well */
}