public Kanji(String character_, String meaning_, String oR_, String oK_, String kR_, String kH_) {
    this.character = character_;
    this.meaning = meaning_;
    this.onyomi = new Onyomi();
    this.kunyomi = new Kunyomi();
    this.onyomi.romaji = oR_;
    this.onyomi.katakana = oK_;
    this.kunyomi.romaji = kR_;
    this.kunyomi.hiragana = kH_;
}