Characters characters = event.asCharacters();
data = characters.getData();

if(characters.isCData()) {
/* handle CDATA */
} else if (characters.isWhiteSpace()) {
/* handle whitespace*/
} else if (characters.isIgnorableWhiteSpace()) {
/* handle ignorable whitespace*/
}