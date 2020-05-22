@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Language)) return false;
    Language language = (Language) o;
    return getLanguageCode().equals(language.getLanguageCode());
}

@Override
public int hashCode() {
    return Objects.hash(getLanguageCode());
}