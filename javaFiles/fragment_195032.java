// Unescaped (actual answer)
var value = [(${data.scriptValue})];
//or
var value = [# th:utext="${data.scriptValue}"/];

// Escaped
var value = [[${data.scriptValue}]];
//or
var value = [# th:text="${data.scriptValue}"/];