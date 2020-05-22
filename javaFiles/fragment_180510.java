public DelimitedLineTokenizer build() {
        Assert.notNull(this.fieldSetFactory, "A FieldSetFactory is required.");
        Assert.notEmpty(this.names, "A list of field names is required");

        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();

        tokenizer.setNames(this.names.toArray(new String[this.names.size()]));

        // the hasText ignores the tab delimiter.

        if(StringUtils.hasText(this.delimiter)) {
            tokenizer.setDelimiter(this.delimiter);
        }
// more code