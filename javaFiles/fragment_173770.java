/**
 * Adds an <CODE>Element</CODE> to the <CODE>List</CODE>.
 *
 * @param   o       the element to add.
 * @return true if adding the object succeeded
 * @since 5.0.1 (signature changed to use Element)
 */
@Override
public boolean add(final Element o) {
    if (o instanceof ListItem) {
        ListItem item = (ListItem) o;
        if (this.numbered || this.lettered) {
            Chunk chunk = new Chunk(this.preSymbol, this.symbol.getFont());
            chunk.setAttributes(this.symbol.getAttributes());
            int index = this.first + this.list.size();
            if ( this.lettered )
                chunk.append(RomanAlphabetFactory.getString(index, this.lowercase));
            else
                chunk.append(String.valueOf(index));
            chunk.append(this.postSymbol);
            item.setListSymbol(chunk);
        }
        else {
            item.setListSymbol(this.symbol);
        }
        item.setIndentationLeft(this.symbolIndent, this.autoindent);
        item.setIndentationRight(0);
        return this.list.add(item);
    }
    else if (o instanceof List) {
        List nested = (List) o;
        nested.setIndentationLeft(nested.getIndentationLeft() + this.symbolIndent);
        this.first--;
        return this.list.add(nested);
    }
    return false;
}