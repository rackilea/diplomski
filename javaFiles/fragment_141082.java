function top5_10 (x) {
  var ten = Math.pow(10, Math.ceiling(Math.ln(x)/Math.LN10)));
  if (ten > 10 * x) { ten = ten / 10; }
  else if (ten <= x) { ten = 10 * ten; }
  return x < ten / 2 ? ten / 2 : ten;
}