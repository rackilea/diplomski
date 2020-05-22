import org.apache.tools.ant.filters.ReplaceTokens

contents {  // contents section in distribution
  from('src/main/scripts') {
    filter(ReplaceTokens, tokens: [placeholder: 'replacement-string' ])
    filteringCharset = 'UTF-8'
  }
}