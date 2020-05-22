Character[] refArray = (Character[]) st.toArray();
char[] charArray = new char[refArray.length];
for (int i = 0; i < refArray.length; i++) {
    charArray[i] = refArray[i];
}
return charArray;