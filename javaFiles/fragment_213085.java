import org.jsoup.safety.Whitelist;

public enum StringModifier {

    DETAIL {
        @Override
        public Whitelist whitelist() {
                return new Whitelist()
                    .addTags("strong", "i", "li", "ul", "br", "u", "b", "a")
                    .addAttributes("a", "href");
        }
    },

    TEASER {
        @Override
        public Whitelist whitelist() {
                return new Whitelist()
                    .addTags();
        }
    },

    INCLUSIVE {
        @Override
        public Whitelist whitelist() {
                return new Whitelist()
                    .addTags("strong", "i", "li", "ul", "br", "u", "b");
        }
    },

    DOCINFO {
        @Override
        public Whitelist whitelist() {
                return new Whitelist()
                    .addTags("br", "li", "ul");
        }
    },

    INTERNAL {
        @Override
        public Whitelist whitelist() {
                return new Whitelist()
                .addTags(
                        "a", "b", "blockquote", "br", "caption", "cite", "code", "col",
                        "colgroup", "dd", "div", "dl", "dt", "em", "h1", "h2", "h3", "h4", "h5", "h6",
                        "i", "img", "li", "ol", "p", "pre", "q", "small", "span", "strike", "strong",
                        "sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr", "u",
                        "ul")

                .addAttributes("a", "href", "title")
                .addAttributes("blockquote", "cite")
                .addAttributes("col", "span", "width")
                .addAttributes("colgroup", "span", "width")
                .addAttributes("img", "align", "alt", "height", "src", "title", "width")
                .addAttributes("ol", "start", "type")
                .addAttributes("q", "cite")
                .addAttributes("table", "summary", "width")
                .addAttributes("td", "abbr", "axis", "colspan", "rowspan", "width")
                .addAttributes(
                        "th", "abbr", "axis", "colspan", "rowspan", "scope",
                        "width")
                .addAttributes("ul", "type")

                .addProtocols("a", "href", "ftp", "http", "https", "mailto")
                .addProtocols("blockquote", "cite", "http", "https")
                .addProtocols("cite", "cite", "http", "https")
                .addProtocols("img", "src", "http", "https")
                .addProtocols("q", "cite", "http", "https")
                ;
        }
    },

    OTHER {
        @Override
        public Whitelist whitelist() {
                return new Whitelist()
                    .addTags();
        }
    };

    public abstract Whitelist whitelist();

}