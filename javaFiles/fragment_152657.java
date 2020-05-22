protected BackReplacer createBackReplacer(Map<ReplacementKey, String> replacementMap) {
        if (replacementMap.isEmpty()) {
            return new BackReplacer() {
                @Override
                public String backReplace(String str) {
                    return str;
                }
            };
        }

        if (replacementMap.size() > MAX_SIZE_FOR_REGEX) {
            final String[] searchStrings = new String[replacementMap.size()];
            final String[] replacementStrings = new String[replacementMap.size()];

            int counter = 0;
            for (Map.Entry<ReplacementKey, String> replacementEntry : replacementMap.entrySet()) {
                searchStrings[counter] = replacementEntry.getValue();
                replacementStrings[counter] = replacementEntry.getKey().getValue();
                counter++;
            }

            return new BackReplacer() {
                @Override
                public String backReplace(String str) {
                    return StringUtils.replaceEach(str, searchStrings, replacementStrings);
                }
            };
        }

        final Map<String, String> replacements = new HashMap<>();
        StringBuilder patternBuilder = new StringBuilder();

        patternBuilder.append('(');
        for (Map.Entry<ReplacementKey, String> entry : replacementMap.entrySet()) {
            replacements.put(entry.getValue(), entry.getKey().getValue());
            patternBuilder.append(entry.getValue()).append('|');
        }

        patternBuilder.setLength(patternBuilder.length() - 1);
        patternBuilder.append(')');

        final Pattern pattern = Pattern.compile(patternBuilder.toString());

        return new BackReplacer() {
            @Override
            public String backReplace(String str) {
                if (str.isEmpty()) {
                    return str;
                }

                StringBuffer sb = new StringBuffer(str.length());

                Matcher matcher = pattern.matcher(str);
                while (matcher.find()) {
                    matcher.appendReplacement(sb, replacements.get(matcher.group(0)));
                }
                matcher.appendTail(sb);

                return sb.toString();
            }
        };
    }