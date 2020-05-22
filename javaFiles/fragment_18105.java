const PATTERNS = [/"(\[)/g, /(\])"/g]; // Invalid patterns
const JsonFixer = json => PATTERNS.reduce((s, re) => s.replace(re, '$1'), json);

var rawJsonResponse = '{"d":"[{\"username\":\"ABC\",\"designation\":\"\"}]"}';

console.log(JSON.parse(JsonFixer(rawJsonResponse)));