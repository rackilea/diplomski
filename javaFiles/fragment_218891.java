Matcher matcher = pattern.matcher(string)
if (matcher.find()) {
    start = matcher.start()
    end = matcher.end()
    text = matcher.group()
}