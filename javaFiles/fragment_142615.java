package com.stackoverflow.mylyn;

import java.io.StringWriter;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.core.parser.builder.HtmlDocumentBuilder;
import org.eclipse.mylyn.wikitext.core.parser.markup.MarkupLanguage;
import org.eclipse.mylyn.wikitext.core.util.ServiceLocator;

/**
 * Utility to parse Wiki Text of varying languages and convert to HTML.
 */
public final class ParseWikiToHTMLUtility {

    public static final String NAME_TEXTILE = "Textile";
    public static final String NAME_TRACWIKI = "TracWiki";
    public static final String NAME_MEDIAWIKI = "MediaWiki";
    public static final String NAME_CONFLUENCE = "Confluence";
    public static final String NAME_TWIKI = "TWiki";

    private ParseWikiToHTMLUtility() {
            /* Do not instantiate utility classes */
    }

    public static String parseTextile(String wikiText) {

            return parseByLanguage(NAME_TEXTILE, wikiText);
    }

    public static String parseTracWiki(String wikiText) {

            return parseByLanguage(NAME_TRACWIKI, wikiText);
    }

    public static String parseMediaWiki(String wikiText) {

            return parseByLanguage(NAME_MEDIAWIKI, wikiText);
    }

    public static String parseConfluence(String wikiText) {

            return parseByLanguage(NAME_CONFLUENCE, wikiText);
    }

    public static String parseTWiki(String wikiText) {

            return parseByLanguage(NAME_TWIKI, wikiText);
    }

    public static String parseByLanguage(String name, String wikiText) {

            return parseByLanguage(ServiceLocator.getInstance().getMarkupLanguage(name), wikiText);
    }

    public static String parseByLanguage(MarkupLanguage language, String wikiText) {

            StringWriter writer = new StringWriter();
            HtmlDocumentBuilder builder = new HtmlDocumentBuilder(writer);
            MarkupParser parser = new MarkupParser(language, builder);
            parser.parse(wikiText);
            return writer.toString();                
    }

    /**
     * MarkupLanguage API prefers we retrieve the MarkupLanguge by name from 
     * the ServiceLocator; since there are no name constants, we obtain the names 
     * from this method or alternately use the hard-coded names from this utility class, 
     * which were pulled directly from a prior call to this very method. 
     */
    public static Set<String> getLanguageNames() {

            Set<String> languages = new TreeSet<String>();
            for (MarkupLanguage s : ServiceLocator.getInstance().getAllMarkupLanguages()) {
                    languages.add(s.getName());
            }

            return languages;
    }        
}