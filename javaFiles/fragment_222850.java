Object readObject = in.readObject();
if (readObject instanceof Squad) {
    Squad s = (Squad) readObject; //Line 33
    in.close();
    return s;
}