/**
 * Utility class for parsing record field parameters in properties.
 *
 * @author Ryan
 *
 */
public static class PropertyParser {

    /**
     * Stores the results of parsing a property.
     *
     * @author Ryan
     *
     */
    public static class ParsedParameters {

        private final Set<String> literals;
        private final Set<String> parameters;

        private ParsedParameters() {
            this.parameters = new HashSet<String>();
            this.literals = new HashSet<String>();
        }

        /**
         * Adds a literal property value to this object.
         *
         * @param string The literal property value to add to this object.
         */
        private void addLiteral(String string) {
            this.literals.add(string);
        }

        /**
         * Adds a parameter name to this object.
         *
         * @param string The parameter name to add to this object.
         */
        private void addParameter(String string) {
            this.parameters.add(string);
        }

        /**
         * Returns the set of literals stored in this object.
         * 
         * @return The set of literals stored in this object.
         */
        public Set<String> getLiterals() {
            return this.literals;
        }

        /**
         * Returns the set of parameters stored in this object.
         *
         * @return The set of parameters stored in this object.
         */
        public Set<String> getParameters() {
            return this.parameters;
        }
    }

    private static final String BAD_FIELD_CHAR =
            "Illegal character detected for field parameter: %c";

    /**
     * Extracts placeholder field name parameters from the input string.
     * <p>
     * Single quotes can be used to avoid the parser interpreting the ${...}
     * as a field parameter.
     * <p>
     * For example, the parser would not detect any field parameters in the following string:
     * <p>
     * &nbsp;&nbsp;&nbsp;#!/bin/bash<br>
     * &nbsp;&nbsp;&nbsp;# Echos the first argument<br>
     * &nbsp;&nbsp;&nbsp;echo '${1}'<br>
     * <p>
     * The {@link #PropertySubstitutor()} is responsible for removing the single quotes
     * surrounding the parameter when substituting the actual property value(s).
     * <p>
     * <b>Nested Parameters</b>
     * <p>
     * This parser itself will only parse the inner-most parameter or literal.
     * <p>
     * For example, ${Some${Value}} would actually be treated as a legal string, with
     * 'Value' as the only field parameter extracted.  During runtime substitution,
     * this would result in ${Somebody} if the record value for the field "Value" was "body".
     * <p>
     * Theoretically, this parser could then be ran again to extract this generated parameter.
     *
     * @param string The property to parse for field parameters.
     * @return An object containing the parsed parameters and literal values.
     * @throws IllegalArgumentException If the property contains parameter syntax
     *         (i.e. ${text}) but contains illegal characters for the field.
     *         <p>
     *         Allowed characters for field names are alpha-numeric and underscores.
     */
    public static ParsedParameters parseParametersAndLiterals(String string)
            throws IllegalArgumentException {
        if ((string == null) || string.isEmpty()) {
            return new ParsedParameters();
        }
        ParsedParameters result = new ParsedParameters();
        StringBuffer param = null;
        Character badChar = null;
        char c;
        char p = '^';
        boolean close = false;
        boolean lQuote = false;
        boolean open = false;
        int l = string.length();
        for (int i = 0; i < l; ++i) {
            c = string.charAt(i);
            if (!lQuote && (p == '\'') && (c == '$')) {
                lQuote = true;
            } else if ((p == '$') && (c == '{')) {
                param = new StringBuffer();
                open = true;
                badChar = null;
            } else if (open
                    && (((c == '}') && (!lQuote || ((1 + i) == l))) || (lQuote && (p == '}')))) {
                open = false;
                close = true;
            } else if (open) {
                boolean validCharacter = Character.isLetterOrDigit(c) || (c == '_');
                if (validCharacter || (lQuote && (c != '}'))) {
                    param.append(c);
                }
                if (!validCharacter && (c != '}')) {
                    badChar = c;
                }
            }
            if (close) {
                if ((badChar != null) && !(lQuote && (p == '}') && (c == '\''))) {
                    throw new IllegalArgumentException(String.format(BAD_FIELD_CHAR, badChar));
                } else if (c != '\'') {
                    if (param.length() > 0) {
                        result.addParameter(param.toString());
                    }
                } else {
                    result.addLiteral(param.toString());
                }
                lQuote = false;
                close = false;
                badChar = null;
            }
            p = c;
        }
        return result;
    }
}