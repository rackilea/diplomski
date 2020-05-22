String partiallyNormalize(String string)
{
    string = string.replace('ñ', '\001');
    string = Normalizer.normalize(string, Normalizer.Form.NFD);
    string = string.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    string = string.replace('\001', 'ñ');
    return string;
}