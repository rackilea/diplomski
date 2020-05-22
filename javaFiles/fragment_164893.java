public Kanji(String character_, String meaning_, String oR_, String oK_, String kR_, String kH_) {
    this.character = character_;
    this.meaning = meaning_;
    this.onyomi = new Onyomi(oR_, oK_);
    this.kunyomi = new Kunyomi(kR_, kH_);
}