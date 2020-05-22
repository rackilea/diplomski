@Override
public String toString() {
    String str = "Book title:" + title + ", author:" + author
                    + ", pages:" + pages + ", price: " + String.format("$%.2f", price);
    return str;
}