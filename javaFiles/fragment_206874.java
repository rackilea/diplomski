string CreateRegex(string pattern) {
  string result = Regex.Replace(pattern, "[^ANT]+", m => Regex.Escape(m.Value));
  result = Regex.Replace(result, "A+", m => "[0-9a-zA-Z]" + (m.Length > 1 ? "{"+m.Length+"}" : ""));
  result = Regex.Replace(result, "T+", m => "[a-zA-Z]" + (m.Length > 1 ? "{"+m.Length+"}" : ""));
  result = Regex.Replace(result, "N+", m => "[0-9]" + (m.Length > 1 ? "{"+m.Length+"}" : ""));
  return "^" + result + "$";
}