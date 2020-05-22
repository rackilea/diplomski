import re
p = re.compile(r'(["\s]|&quot;)(https?://.*?)(?=\1)', re.IGNORECASE)
url = "http://test.url/here.php?var1=val&var2=val2"
formatstr = 'text "{0}" more text {0} and more &quot;{0}&quot; test greed&quot;'
data = formatstr.format(url)    
for m in p.finditer(data):
    print "Found:", m.group(2)