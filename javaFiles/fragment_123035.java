@XmlTransient
public String word;

public void setDeserializedWord(String word) {
   this.word = word;
}

@XmlElement(name="word")
public String getDeserializedWord() {
   return null;
}