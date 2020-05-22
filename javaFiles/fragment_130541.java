String str = "<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>";
String text = "<img alt=\"booo\" src=\"image.jpg\"/>";
Pattern pattern = Pattern.compile (str);
Matcher matcher = pattern.matcher (text);

if (matcher.matches ())
{
      int n = matcher.groupCount ();
      for (int i = 0; i <= n; ++i)
          System.out.println (matcher.group (i));
}