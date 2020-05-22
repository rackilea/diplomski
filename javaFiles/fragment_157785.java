// String text = <file contents from above...the Before contents>
Pattern PATTERN = 
  Pattern.compile("^(On.*?wrote:).*$", Pattern.MULTILINE | Pattern.DOTALL );
Matcher m = PATTERN.matcher(text);
if (m.find()) {
   text = m.replaceAll("");  // This should only contain "test"

}