InputSource inputSource = new InputSource();
Reader characterStream = new StringReader(cssContent);
inputSource.setCharacterStream(characterStream);
CSSStyleSheet stylesheet = cssParserObj.parseStyleSheet(source, null,
            null);
CSSRuleList ruleList = stylesheet.getCssRules();