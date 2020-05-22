private void initializeResource() {
    try {
        final String resourceName = "/pinyindb/unicode_to_hanyu_pinyin.txt";
        final String resourceMultiName = "/pinyindb/multi_pinyin.txt";

        setUnicodeToHanyuPinyinTable(new Trie());
        getUnicodeToHanyuPinyinTable().load(ResourceHelper.getResourceInputStream(resourceName));

        getUnicodeToHanyuPinyinTable().loadMultiPinyin(ResourceHelper.getResourceInputStream(resourceMultiName));

        getUnicodeToHanyuPinyinTable().loadMultiPinyinExtend();

    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}